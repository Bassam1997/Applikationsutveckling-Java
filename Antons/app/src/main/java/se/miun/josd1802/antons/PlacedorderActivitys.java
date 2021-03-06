package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PlacedorderActivitys extends AppCompatActivity {

    private String BASEURL = "http://192.168.0.102:8080/APII/webresources/";

    private TextView textResult;
    private Button button_back;
    private Button button_overview;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placedorder_activitys);

        recyclerView = findViewById(R.id.dish_list);
        button_back = findViewById(R.id.b_back);
        button_overview = findViewById(R.id.b_overview);

        retrofitParser();




        button_back.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(this, MainActivity.class);
            startActivity(intentLoadNewActivity);
        });

        button_overview.setOnClickListener(v -> {
            Intent intentLoadNewActivity = new Intent(this, OverviewActivity.class);
            startActivity(intentLoadNewActivity);
        });


    }

    public void retrofitParser()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ApiHandler apiHandler = retrofit.create(ApiHandler.class);

        Call<dishes> call = apiHandler.getDinners();

        call.enqueue(new Callback<dishes>() {
            @Override
            public void onResponse(Call<dishes> call, Response<dishes> response) {
                if(!response.isSuccessful())
                {
                    textResult.setText("Code: " + response.code());
                    return;
                }

                List<Dinner> dinners = response.body().getL_dinner();



                /*
                for(Dinner dinner : dinners)
                {
                    String content = "";
                    content += "ID: " + dinner.getId() + "\n";
                    content += "Name: " + dinner.getName() + "\n";
                    content += "Price: " + dinner.getPrice() + "\n";
                    content += "Details: " + dinner.getDetails() + "\n\n";

                    textResult.append(content);
                }*/
            }

            @Override
            public void onFailure(Call<dishes> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });
    }

    public void addItem()
    {

    }
}