package me.firdaus1453.basicmvp.network;

import me.firdaus1453.basicmvp.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class ApiClient {
    private static Retrofit retrofit = null;

    // Membuat method return untuk mendapatkan retrofit yang sudah berisi baseUrl
    public static  Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
