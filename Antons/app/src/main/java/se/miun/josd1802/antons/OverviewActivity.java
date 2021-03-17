package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {

    private OverviewAdapter overviewAdapter;
    private ListView listView;
    private Button b_placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        b_placeOrder = (Button) findViewById(R.id.button2);
        b_placeOrder.setOnClickListener(view -> navigateToHome());

        displayOrder();
    }
    public void navigateToHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        ApiAdapter.overViewList.removeAll(ApiAdapter.overViewList);
        startActivity(intent);
    }

    public void displayOrder()
    {
        overviewAdapter = new OverviewAdapter(this, 0, ApiAdapter.overViewList);
        listView = (ListView) findViewById(R.id.overview_listview);
        listView.setAdapter(overviewAdapter);
    }
}