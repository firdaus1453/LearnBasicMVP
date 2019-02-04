package me.firdaus1453.basicmvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class LoginResponse {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
