package me.firdaus1453.basicmvp.login;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public interface LoginContract {
    // Membuat interface untuk method yang dibutuhkan pada View / Interaksi dengan user
    interface View{
        // Menampilkan dan menutup progress loading dialog
        void showProgress();
        void hideProgress();

        // Menampilkan dan melakukan sesuatu pada saat server merespon berhasil ataupun gagal
        void loginFailure(String msg);
        void loginSuccess(String token);
    }

    // Membuat interface untuk method yang dibutuhkan pada Presenter / Mediator dengan model(Bisnis Logic)
    interface Presenter{
        // Method untuk mengesekusi bisnis logic untuk login contoh pengecekan data dan pengiriman
        // data ke Internet
        void doLogin(String email, String password);
    }
}
