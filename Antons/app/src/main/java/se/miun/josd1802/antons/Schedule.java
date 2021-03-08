package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.security.PrivateKey;

public class Schedule extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        setupUIViews();
        initToolbar();
        
    }

    private void setupUIViews() {
        toolbar = (Toolbar)findViewById(R.id.ToolbarSchedule);
        listView = (ListView)findViewById(R.id.lvSchedule);
    }

    private void initToolbar() {
       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Timetable App");
       
    }

    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Week);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context sContext;
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
                convertView = layoutInflater.inflate(R.layout.schedule_singel_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSchedule);
            description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView= (ImageView)convertView.findViewById(R.id.ivSchedule);
            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Monday")){
                imageView.setImageResource(R.drawable.m);
            }
            else if (titleArray[position].equalsIgnoreCase("Tuesday")){
                imageView.setImageResource(R.drawable.t);
            }
            else if (titleArray[position].equalsIgnoreCase("Wednesday")){
                imageView.setImageResource(R.drawable.w);
            }
            else if (titleArray[position].equalsIgnoreCase("Thursday")){
                imageView.setImageResource(R.drawable.t);
            }
            else if (titleArray[position].equalsIgnoreCase("Friday")){
                imageView.setImageResource(R.drawable.f);
            }
            else{
                imageView.setImageResource(R.drawable.s);
            }
// (titleArray[position].equalsIgnoreCase("Suturday"))

            return convertView;


        }
    }

}