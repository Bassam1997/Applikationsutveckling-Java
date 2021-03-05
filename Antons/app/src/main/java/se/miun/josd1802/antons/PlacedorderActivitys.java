package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PlacedorderActivitys extends AppCompatActivity {

    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placedorder_activitys);

        textResult = findViewById(R.id.text_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/RestfulAPI/test-resbeans.html/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ApiHandler apiHandler = retrofit.create(ApiHandler.class);

        Call<List<Dinner>> call = apiHandler.getDinners();

        call.enqueue(new Callback<List<Dinner>>() {
            @Override
            public void onResponse(Call<List<Dinner>> call, Response<List<Dinner>> response)
            {
                // Response code not between 200-300
                if(!response.isSuccessful())
                {
                    textResult.setText("Code: " + response.code());
                    return;
                }

                List<Dinner> dinners = response.body();

                for(Dinner dinner : dinners)
                {
                    String content = "";
                    content += "ID: " + dinner.getId() + "\n";
                    content += "Name: " + dinner.getName() + "\n";
                    content += "Price: " + dinner.getPrice() + "\n";
                    content += "Details: " + dinner.getDetails() + "\n\n";

                    textResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Dinner>> call, Throwable t)
            {
                textResult.setText(t.getMessage());
            }
        });
    }
}