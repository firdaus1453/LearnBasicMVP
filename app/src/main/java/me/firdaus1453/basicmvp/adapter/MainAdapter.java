package me.firdaus1453.basicmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.basicmvp.R;
import me.firdaus1453.basicmvp.model.UserData;
import me.firdaus1453.basicmvp.utils.Constants;
import me.firdaus1453.basicmvp.view.DetailActivity;

/**
 * Created by firdaus1453 on 2/4/2019.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private final List<UserData> userDataList;


    public MainAdapter(Context context, List<UserData> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final UserData userData = userDataList.get(position);

        holder.txtFirst.setText(userData.getFirstName());
        holder.txtLast.setText(userData.getLastName());

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);

        Glide.with(context).load(userData.getAvatar()).apply(options).into(holder.imgAvatar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mengirim data menggunakan bundle
                // Buat object bundle
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.KEY_ID,userData.getId());

                // Berpindah halaman dengan membawa data
                context.startActivity(new Intent(context, DetailActivity.class).putExtras(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgAvatar)
        ImageView imgAvatar;
        @BindView(R.id.txtFirst)
        TextView txtFirst;
        @BindView(R.id.txtLast)
        TextView txtLast;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
