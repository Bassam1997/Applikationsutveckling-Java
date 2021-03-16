package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        Spinner spinner4 = findViewById(R.id.spinner4);
        Spinner spinner5 = findViewById(R.id.spinner5);
        Spinner spinner6 = findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



  /*  private Button b_oversikt;
    private EditText e_måltid1;
    private EditText e_måltid2;
    private EditText e_måltid3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        e_måltid1 = (EditText) findViewById(R.id.antalMåltid1);
        e_måltid2 = (EditText) findViewById(R.id.antalMåltid2);
        e_måltid3 = (EditText) findViewById(R.id.antalMåltid3);

        b_oversikt = (Button) findViewById(R.id.översikt);
        b_oversikt.setOnClickListener(view -> navigateToOrder());
        }
        public void navigateToOrder()
        {
            Intent intent = new Intent(this, OverviewActivity.class);

            intent.putExtra("#1", "Måltid1 : " + "Antal: " + e_måltid1.getText().toString());
            intent.putExtra("#2", "Måltid2 : " + "Antal: " + e_måltid2.getText().toString());
            intent.putExtra("#3", "Måltid3 : " + "Antal: " + e_måltid3.getText().toString());

            startActivity(intent);
        } */
    }