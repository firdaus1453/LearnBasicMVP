package me.firdaus1453.basicmvp.login;

import me.firdaus1453.basicmvp.model.LoginBody;
import me.firdaus1453.basicmvp.model.LoginResponse;
import me.firdaus1453.basicmvp.network.ApiClient;
import me.firdaus1453.basicmvp.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class LoginPresenter implements LoginContract.Presenter {

    // TODO 1 Menyiapkan variable yang dibtuhkan
    // Membuat object apiInterface untuk mensetting baseUrl retrofit
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    // Membuat object LoginContract View
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        // Mencek email dan password apakah ada isinya
        if (email == null || email.isEmpty()){
            view.loginFailure("Email kosong");
            return;
        }

        if (password == null || password.isEmpty()){
            view.loginFailure("Password Kosong");
            return;
        }

        // Menampilkan progress dialog agar memberitahu ada proses yang sedang berjalan
        view.showProgress();

        // Memasukkan data email dan password ke dalam LoginBody
        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(email);
        loginBody.setPassword(password);

        // Mengesekusi data ke server
        // Membuat object call untuk mengirim loginbody
        Call<LoginResponse> call = apiInterface.postLogin(loginBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // View menutup progress dialog
                view.hideProgress();

                // Mencek response apakah ada isinya?
                if (response.body() != null){
                    // Mengambil data response body dan memasukkan ke dalam class model LoginResponse
                    LoginResponse loginResponse = response.body();
                    // Mencek isi token apakah ada isinya? agar tidak forceclose apabila null
                    if (loginResponse.getToken() != null){
                        // Login succes mengirimkan token dan meminta view untuk berpindah halaman
                        view.loginSuccess(loginResponse.getToken());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                // Menutup progress dialog
                view.hideProgress();
                // Menampilkan pesan failure ke Toast di view
                view.loginFailure(throwable.getMessage());
            }
        });

    }
}
