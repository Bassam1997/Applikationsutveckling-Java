package se.miun.josd1802.antons;

import retrofit2.Call;

import retrofit2.http.GET;

public interface ApiHandler
{
    @GET("entities.dinner")
    Call<dishes> getDinners();
}
