package se.miun.josd1802.antons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import se.miun.josd1802.antons.Utils.LetterImageView;

public class Chef extends AppCompatActivity {

    private String BASEURL = "http://192.168.0.102:8080/Antons_SkafferiNy1/webresources/";

    private Toolbar toolbar;
    private ListView listView;
    private ChefAdapter adapter;
    private ChefInterface chefInterface;

    public static ArrayList<Kitchen> pending_list = new ArrayList<Kitchen>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        setupUIViews();
        initToolbar();
        setupListView();

        retrofitParser();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarChef);
        listView = (ListView)findViewById(R.id.chef_listview);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chef");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupListView() {

        this.adapter = new ChefAdapter(this, R.layout.chef_activity_single_item, pending_list);
        listView.setAdapter(adapter);
    }

    public void sendData(Kitchen k)
    {
        // Skapa en klass som ska innehålla en dinner objekt för vår POST REQUEST

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ChefInterface chefInterface = retrofit.create(ChefInterface.class);

        Pending pending = new Pending();

        pending.setId(k.getId());
        pending.setName(k.getName());
        pending.setDescription(k.getDescription());

        Call<pendings> call = chefInterface.setPendings(pending);
        call.enqueue(new Callback<pendings>()
        {
            @Override
            public void onResponse(Call<pendings> call, Response<pendings> res)
            {
                if(!res.isSuccessful())
                {
                    System.out.println(res.code());
                    return;
                }
            }

            @Override
            public void onFailure(Call<pendings> call, Throwable t)
            {
                System.out.println(t);
            }
        });
    }

    public void removeItem(int kitchen)
    {
        Call<kitchens> call = chefInterface.removeDinner(kitchen);
        call.enqueue(new Callback<kitchens>() {
            @Override
            public void onResponse(Call<kitchens> call, Response<kitchens> response) {

            }

            @Override
            public void onFailure(Call<kitchens> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    public void retrofitParser()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        chefInterface = retrofit.create(ChefInterface.class);

        Call<kitchens> call = chefInterface.getDinners();

        call.enqueue(new Callback<kitchens>()
        {
            @Override
            public void onResponse(Call<kitchens> call, Response<kitchens> response)
            {
                if(!response.isSuccessful()) {
                    System.out.println("Error, could not load data from API..");
                }

                ArrayList<Kitchen> k = response.body().getL_dinner();
                pending_list = k;
            }

            @Override
            public void onFailure(Call<kitchens> call, Throwable t)
            {
                System.out.println(t);
            }
        });
    }


    public class ChefAdapter extends ArrayAdapter
    {
        public ArrayList<Kitchen> l_dinner = new ArrayList<Kitchen>();
        private LayoutInflater inflater;
        private int resource;

        public ChefAdapter (Context context, int resource, ArrayList<Kitchen> l_dinner)
        {
            super(context, resource, l_dinner);
            this.resource = resource;
            this.l_dinner = l_dinner;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent)
        {
            ViewHolder holder;
            if(convertView == null)
            {
                holder = new ViewHolder();
                convertView = inflater.inflate(resource, null);

                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.chef_name = (TextView) convertView.findViewById(R.id.tvChef);
                holder.chef_description = (TextView) convertView.findViewById(R.id.tvDescription);
                holder.button_chef = (Button)convertView.findViewById(R.id.b_chef);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(l_dinner.get(position).getName().charAt(0));
            holder.chef_name.setText(l_dinner.get(position).getName());
            holder.chef_description.setText(l_dinner.get(position).getDescription());

            holder.button_chef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendData(l_dinner.get(position));
                    removeItem(l_dinner.get(position).getId());
                    l_dinner.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        class ViewHolder
        {
            private TextView chef_name;
            private LetterImageView ivLogo;
            private TextView chef_description;
            private Button button_chef;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
           switch(item.getItemId()){
                case android.R.id.home : {
                    onBackPressed();
                }
            }
            return super.onOptionsItemSelected(item);
        }
}