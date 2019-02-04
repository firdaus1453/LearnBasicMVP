package me.firdaus1453.basicmvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.basicmvp.R;
import me.firdaus1453.basicmvp.detail.DetailContract;
import me.firdaus1453.basicmvp.detail.DetailPresenter;
import me.firdaus1453.basicmvp.model.UserData;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @BindView(R.id.imgAvatar)
    ImageView imgAvatar;
    @BindView(R.id.txtFirst)
    TextView txtFirst;
    @BindView(R.id.txtLast)
    TextView txtLast;

    // TODO 1 Menyiapkan variable yang dibutuhkan
    private ProgressDialog progressDialog;
    private final DetailPresenter detailPresenter = new DetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // TODO 2 mengirimkan bundle ke Presenter untuk di cek dan merequest data single user ke API
        // dengan ID
        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDataSingleUser(bundle);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataSingleUser(UserData userData) {
        // TODO 3 Menampilkan data yang diberikan oleh presenter ke layar
        txtFirst.setText(userData.getFirstName());
        txtLast.setText(userData.getLastName());

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);

        Glide.with(this).load(userData.getAvatar()).apply(options).into(imgAvatar);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
