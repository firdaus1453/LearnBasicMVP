package me.firdaus1453.basicmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class UserResponse {

    @SerializedName("data")
    private List<UserData> userDataList;

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }
}
