package me.firdaus1453.basicmvp.network;

import me.firdaus1453.basicmvp.model.LoginBody;
import me.firdaus1453.basicmvp.model.LoginResponse;
import me.firdaus1453.basicmvp.model.SingleUserResponse;
import me.firdaus1453.basicmvp.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public interface ApiInterface {

    // membuat endpoint login
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body LoginBody loginBody);

    // Membuat endpoint get data user
    @GET("api/users")
    Call<UserResponse> getDataUser(@Query("per_page") int perPage);

    // Membuat endpoint untuk get data single user
    @GET("api/users/{id}")
    Call<SingleUserResponse> getDataSingleUser(@Path("id") int id);
}
