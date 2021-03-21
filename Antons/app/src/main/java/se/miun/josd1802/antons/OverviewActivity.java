package se.miun.josd1802.antons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class OverviewActivity extends AppCompatActivity {
    private String BASEURL = "http://192.168.0.102:8080/Antons_SkafferiNy1/webresources/";

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
        sendData();
        ApiAdapter.overviewList_chef.removeAll(ApiAdapter.overviewList_chef);
        startActivity(intent);
    }

    public void displayOrder()
    {
        overviewAdapter = new OverviewAdapter(this, 0, ApiAdapter.overviewList_chef);
        listView = (ListView) findViewById(R.id.overview_listview);
        listView.setAdapter(overviewAdapter);
    }

    public void sendData()
    {
        // Skapa en klass som ska innehålla en dinner objekt för vår POST REQUEST

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        OverviewInterface overviewInterface = retrofit.create(OverviewInterface.class);
        
        for(Dinner d : ApiAdapter.overviewList_chef)
        {
            Kitchen kitchen = new Kitchen();

            kitchen.setId(d.getId());
            kitchen.setName(d.getName());
            kitchen.setDescription(d.getDescription());
            Call<Kitchen> call = overviewInterface.sendDinners(kitchen);
            call.enqueue(new Callback<Kitchen>()
            {
                @Override
                public void onResponse(Call<Kitchen> call, Response<Kitchen> res)
                {
                    if(!res.isSuccessful())
                    {
                        System.out.println(res.code());
                        return;
                    }
                }

                @Override
                public void onFailure(Call<Kitchen> call, Throwable t)
                {
                    System.out.println(t);
                }
            });
        }
    }
}