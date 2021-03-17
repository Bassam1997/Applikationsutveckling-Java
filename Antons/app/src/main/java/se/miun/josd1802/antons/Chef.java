package se.miun.josd1802.antons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import se.miun.josd1802.antons.Utils.LetterImageView;

public class Chef extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    public static ArrayList<Dinner> pending_list = new ArrayList<Dinner>();
    private MakeOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews()
    {
        toolbar = (Toolbar) findViewById(R.id.ToolbarChef);
        listView = (ListView)findViewById(R.id.lvChef);
    }

    private void initToolbar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chef");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupListView()
    {
        this.adapter = new MakeOrderAdapter(this, R.layout.chef_activity_single_item, ApiAdapter.overviewList_chef);
        listView.setAdapter(adapter);
    }


    public class MakeOrderAdapter extends ArrayAdapter
    {

        private int resource;
        private LayoutInflater layoutInflater;
        private ArrayList<Dinner> list = new ArrayList<Dinner>();


        public MakeOrderAdapter(Context context, int resource, ArrayList<Dinner> list)
        {
            super(context, resource, list);
            this.resource = resource;
            this.list = list;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent)
        {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvChef = (TextView)convertView.findViewById(R.id.tvChef);
                holder.tvDesc = (TextView)convertView.findViewById(R.id.tvDescription);
                holder.button_chef = (Button)convertView.findViewById(R.id.b_chef);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(list.get(position).getName().charAt(0));
            holder.tvChef.setText(list.get(position).getName());
            holder.tvDesc.setText(list.get(position).getDetails());


            holder.button_chef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    pending_list.add(ApiAdapter.overviewList_chef.get(position));
                    ApiAdapter.overviewList_chef.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvChef;
            private TextView tvDesc;
            private Button button_chef;
        }

        public int getCount()
        {
            return list.size();
        }

        public long getItemId(int position)
        {
            return position;
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