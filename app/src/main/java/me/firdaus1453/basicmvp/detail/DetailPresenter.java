package me.firdaus1453.basicmvp.detail;

import android.os.Bundle;

import me.firdaus1453.basicmvp.model.SingleUserResponse;
import me.firdaus1453.basicmvp.network.ApiClient;
import me.firdaus1453.basicmvp.network.ApiInterface;
import me.firdaus1453.basicmvp.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class DetailPresenter implements DetailContract.Presenter {

    // TODO 1 membuat konstruktor dan variable yang dibtuhkan
    private final DetailContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    private int id;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataSingleUser(Bundle bundle) {
//        TODO 2 Mencek bundle apakah ada isinya?
        if (bundle != null){
            // Mengambil id dan dimasukkan ke dalam variable id
            id = bundle.getInt(Constants.KEY_ID);

            // TODO 3 Mengambil data dengan id
            // Tampilkan progress dialog
            view.showProgress();

            Call<SingleUserResponse> call = apiInterface.getDataSingleUser(id);
            call.enqueue(new Callback<SingleUserResponse>() {
                @Override
                public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                    // Menutup progress dialog
                    view.hideProgress();

                    // Mencek response body
                    if (response.body() != null){
                        // Memasukkan response body ke dalam SingleUserResponse
                        SingleUserResponse singleUserResponse = response.body();
                        // Mencek apakah data singleUSerResponse ada isinya?
                        if (singleUserResponse.getUserData() != null){
                            // Mengirimkan data single user ke view untuk di tampilkan
                            view.showDataSingleUser(singleUserResponse.getUserData());
                        }
                    }
                }

                @Override
                public void onFailure(Call<SingleUserResponse> call, Throwable throwable) {
                    view.hideProgress();
                    view.showFailureMessage(throwable.getMessage());
                }
            });

        }


    }
}
