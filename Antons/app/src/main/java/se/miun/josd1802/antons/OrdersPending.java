package se.miun.josd1802.antons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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


public class OrdersPending extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private MakeOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarOrdersPending);
        listView = (ListView)findViewById(R.id.lvOrdersPending);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Orders Pending");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setupListView() {

        this.adapter = new MakeOrderAdapter(this, R.layout.orders_pending_activity_single_item, Chef.pending_list);
        listView.setAdapter(adapter);
    }

    public class MakeOrderAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private ArrayList<Dinner> list = new ArrayList<Dinner>();


        public MakeOrderAdapter(Context context, int resource, ArrayList<Dinner> list) {
            super(context, resource, list);
            this.resource = resource;
            this.list = list;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvOrdersPending = (TextView)convertView.findViewById(R.id.tvOrdersPending);
                holder.button_pending = (Button)convertView.findViewById(R.id.b_pending);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(list.get(position).getName().charAt(0));
            holder.tvOrdersPending.setText(list.get(position).getName());


            holder.button_pending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Chef.pending_list.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        class ViewHolder {
            private LetterImageView ivLogo;
            private TextView tvOrdersPending;
            private Button button_pending;
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