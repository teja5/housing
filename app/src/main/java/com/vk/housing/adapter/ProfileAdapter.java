package com.vk.housing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.housing.R;
import com.vk.housing.data.remote.dao.Settings;
import com.vk.housing.util.OnActionClickListener;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.HomeViewHolder> {

    private ArrayList<Settings> settings;

    private Context context;

    private OnActionClickListener onActionClickListener;

    public ProfileAdapter(ArrayList<Settings> settings, Context context, OnActionClickListener onActionClickListener) {
        this.settings = settings;
        this.context = context;
        this.onActionClickListener = onActionClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.setting_item, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {

        Settings setting = settings.get(i);
        homeViewHolder.tv_name_setting.setText(setting.getName());
        homeViewHolder.iv_name.setOnClickListener(view -> onActionClickListener.onItemClickListener(i, setting));

    }

    @Override
    public int getItemCount() {
        return settings.size();
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name_setting;

        private ImageView iv_name;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_setting = itemView.findViewById(R.id.tv_name_setting);
            iv_name = itemView.findViewById(R.id.iv_name);
        }
    }
}
