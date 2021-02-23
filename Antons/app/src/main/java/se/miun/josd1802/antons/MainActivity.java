package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b_a_order;
    private Button b_a_orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_a_orders = (Button) findViewById(R.id.orders);
        b_a_order = (Button) findViewById(R.id.order);
        b_a_orders.setOnClickListener(view -> openOrdersActivity());
        b_a_order.setOnClickListener(view -> openOrderActivity());
    }

    public void openOrdersActivity()
    {
        Intent intent = new Intent(this, PlacedorderActivitys.class);
        startActivity(intent);
    }


    public void openOrderActivity()
    {
        Intent intent = new Intent(this, Order.class);
        startActivity(intent);
    }
}