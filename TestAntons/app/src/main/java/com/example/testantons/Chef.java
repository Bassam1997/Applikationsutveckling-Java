package com.example.testantons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.testantons.Utils.LetterImageView;

public class Chef extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);


        setupUIViews();
        initToolbar();
        setupListView();

    }


    private void setupUIViews() {
        toolbar = (Toolbar)findViewById(R.id.ToolbarChef);
        listView = (ListView)findViewById(R.id.lvChef);
    }


    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chef");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void setupListView() {
        String[] Chef = getResources().getStringArray(R.array.Chef);

        MakeOrderAdapter adapter = new MakeOrderAdapter(this, R.layout.chef_activity_single_item, Chef);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0: { break; }
                    case 1: { break; }
                    case 2: { break; }
                    case 3: { break; }
                    case 4: { break; }
                    // case 5: { break; }
                    //  case 6: { break; }
                    //  case 7: { break; }
                    //case 8: { break; }
                    //  case 9: { break; }
                    default:break;

                }
            }
        });
    }

    public class MakeOrderAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] Chef = new String[]{};


        public MakeOrderAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.Chef = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvChef = (TextView)convertView.findViewById(R.id.tvMain);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(Chef[position].charAt(0));
            //holder.tvMakeOrder.setText(Make_Order[position]);



            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvChef;
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