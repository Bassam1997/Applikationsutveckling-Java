package se.miun.josd1802.antons;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ChefInterface
{
    @GET("entities.kitchen")
    Call<kitchens> getDinners();

    @POST("entities.orderpending")
    Call<pendings> setPendings(@Body Pending pending);

    @DELETE("entities.kitchen/{id}")
    Call<kitchens> removeDinner(@Path("id") int kitchen);
}
