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
import com.vk.housing.data.remote.dao.Property;
import com.vk.housing.util.OnItemClickListener;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<Property> properties;

    private Context context;

    private OnItemClickListener itemClickListener;

    public HomeAdapter(ArrayList<Property> properties, Context context, OnItemClickListener itemClickListener) {
        this.properties = properties;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property_item, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        Property property = properties.get(i);

        homeViewHolder.tv_property_address.setText(property.getpAddress());

        homeViewHolder.iv_property_item.setOnClickListener(view -> itemClickListener.onItemClickListener(i,property));

    }

    @Override
    public int getItemCount() {
        return properties.size();
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_property_address;

        private ImageView iv_property_item;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_property_address = itemView.findViewById(R.id.tv_property_address);
            iv_property_item = itemView.findViewById(R.id.iv_property_item);
        }
    }

}
