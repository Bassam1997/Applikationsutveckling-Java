package se.miun.josd1802.antons;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface ApiHandler
{
    @GET("entities.dinner")
    Call<dishes> getDinners();
}
