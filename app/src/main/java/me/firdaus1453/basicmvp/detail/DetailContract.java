package me.firdaus1453.basicmvp.detail;

import android.os.Bundle;

import me.firdaus1453.basicmvp.model.UserData;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataSingleUser(UserData userData);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataSingleUser(Bundle bundle);
    }
}
