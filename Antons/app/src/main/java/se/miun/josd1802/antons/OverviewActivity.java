package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OverviewActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        text = findViewById(R.id.textResult);
        String id = getIntent().getStringExtra("Key");
        text.setText(id);
    }
}