package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    private ImageButton MakeOrder;
    private ImageButton PendingOrders;
    private ImageButton Chef;
    private ImageButton Schema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeOrder = (ImageButton) findViewById(R.id.Make_Order);
        PendingOrders = (ImageButton) findViewById(R.id.Orders_Pending);
        Chef = (ImageButton) findViewById(R.id.Chef);
        Schema = (ImageButton) findViewById(R.id.Schema);

        MakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Order.class);
                startActivity(intentLoadNewActivity);
            }

        });
        PendingOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Pending_order.class);
                startActivity(intentLoadNewActivity);

            }
        });

        Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Pending_order.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Schema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Schedule.class);
                startActivity(intentLoadNewActivity);
            }
        });


        //MakeOrder.setOnClickListener(view -> openOrdersActivity());
        //PendingOrders.setOnClickListener(view -> openOrderActivity());
    }

   // public void openOrdersActivity()
    //{
      //  Intent intent = new Intent(this, PlacedorderActivitys.class);
       // startActivity(intent);
   // }


  //  public void openOrderActivity()
  //  {
  //      Intent intent = new Intent(this, Order.class);
   //     startActivity(intent);
   // }
}