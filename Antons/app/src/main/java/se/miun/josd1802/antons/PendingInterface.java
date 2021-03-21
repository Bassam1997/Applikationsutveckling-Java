package se.miun.josd1802.antons;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PendingInterface
{
    @GET("entities.orderpending")
    Call<pendings> getDinners();

    @POST("entities.orderpending")
    Call<Pending> sendDinners(@Body Pending pending);

    @DELETE("entities.orderpending/{id}")
    Call<pendings> removeDinner(@Path("id") int order);
}
