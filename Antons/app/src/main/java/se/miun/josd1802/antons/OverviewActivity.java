package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class OverviewActivity extends AppCompatActivity {

    private List<Dinner> overviewList;
    private Button b_placeOrder;
    private TextView måltid1;
    private TextView måltid2;
    private TextView måltid3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        b_placeOrder = (Button) findViewById(R.id.button2);
        b_placeOrder.setOnClickListener(view -> navigateToHome());

        måltid1 = findViewById(R.id.textResult);
        måltid2 = findViewById(R.id.textResult1);
        måltid3 = findViewById(R.id.textResult2);

        String nr1 = getIntent().getStringExtra("#1");
        String nr2 = getIntent().getStringExtra("#2");
        String nr3 = getIntent().getStringExtra("#3");

        måltid1.setText(nr1);
        måltid2.setText(nr2);
        måltid3.setText(nr3);
    }
    public void navigateToHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void retriveList()
    {
        Intent i = getIntent();
        overviewList = (List<Dinner>) i.getSerializableExtra("LIST");
        System.out.println(overviewList);
    }
}