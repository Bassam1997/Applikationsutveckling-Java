package se.miun.josd1802.antons;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OverviewInterface
{
    @GET("entities.dinner")
    Call<dishes> getDinners();

    @POST("entities.kitchen")
    Call<Kitchen> sendDinners(@Body Kitchen kitchen);
}
