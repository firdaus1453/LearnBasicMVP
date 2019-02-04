package me.firdaus1453.basicmvp.main;

import java.util.List;

import me.firdaus1453.basicmvp.model.UserData;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();
        // Menampilkan data list user ke view recyclerview
        void showDataListUser(List<UserData> userDataList);

        // Menampilkan pesan gagal
        void showFailureMessage(String msg);
    }

    interface Presenter{
        // Membuat method interface untuk mengambil data dari API
        void getDataListUser();
    }
}
