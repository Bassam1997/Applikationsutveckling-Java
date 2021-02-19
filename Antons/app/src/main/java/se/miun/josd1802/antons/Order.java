package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Order extends AppCompatActivity {
    private Button b_oversikt;
    private EditText e_måltid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //getSupportFragmentManager().beginTransaction().add();
        b_oversikt = (Button) findViewById(R.id.översikt);
        b_oversikt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", e_måltid1.getText().toString());
            }
        });
        }
    }