package me.firdaus1453.basicmvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class LoginBody {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
