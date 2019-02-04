package me.firdaus1453.basicmvp.network;

import me.firdaus1453.basicmvp.model.LoginBody;
import me.firdaus1453.basicmvp.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public interface ApiInterface {

    // membuat endpoint login
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body LoginBody loginBody);

}
