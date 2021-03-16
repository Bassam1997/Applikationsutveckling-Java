package se.miun.josd1802.antons;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import se.miun.josd1802.antons.Utils.LetterImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*setupUIViews();
        initToolbar();
        setupListView();*/

    }

    /*private void setupUIViews() {
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        listView = (ListView)findViewById(R.id.lvMain);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Antons_Skafferi");

    }

    private void setupListView(){
        String[] Antons_Skafferi = getResources().getStringArray(R.array.main);
        //String[] description = getResources().getStringArray(R.array.Description);

        MainAdapter adapter = new MainAdapter(this, R.layout.main_single_item, Antons_Skafferi);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                   // default:brake;
                }
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }*/

    /*public class MainAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] main = new String[] {};

        public MainAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.main = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivMain = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvMain = (TextView)convertView.findViewById(R.id.tvMain);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivMain;
            private TextView tvMain;

        }

        /* private Context sContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String [] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){
            sContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);

        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvMain);
            description = (TextView)convertView.findViewById(R.id.tvMainDescription);
            imageView= (ImageView)convertView.findViewById(R.id.ivMain);
            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Make Order")){
                imageView.setImageResource(R.drawable.make_order);
            }
            else if (titleArray[position].equalsIgnoreCase("Orders Pending")){
                imageView.setImageResource(R.drawable.orders_pending);
            }
            else if (titleArray[position].equalsIgnoreCase("Chef")){
                imageView.setImageResource(R.drawable.kocken);
            }
            else if (titleArray[position].equalsIgnoreCase("Schedule")){
                imageView.setImageResource(R.drawable.schedule);
            }


           // else
             //   imageView.setImageResource(R.drawable.s);

 //else if (titleArray[position].equalsIgnoreCase("Schedule")){
             //   imageView.setImageResource(R.drawable.schedule);

            return convertView;


        }*/
    }

