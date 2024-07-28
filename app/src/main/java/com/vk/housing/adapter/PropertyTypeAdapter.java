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
import com.vk.housing.data.remote.dao.PropertyType;
import com.vk.housing.util.OnActionClickListener;
import com.vk.housing.util.OnItemClickListener;

import java.util.ArrayList;

public class PropertyTypeAdapter extends RecyclerView.Adapter<PropertyTypeAdapter.PropertyTypeViewHolder> {

    private ArrayList<PropertyType> propertyTypes;

    private Context context;

    private OnActionClickListener onActionClickListener;

    public PropertyTypeAdapter(ArrayList<PropertyType> propertyTypes, Context context, OnActionClickListener onActionClickListener) {
        this.propertyTypes = propertyTypes;
        this.context = context;
        this.onActionClickListener = onActionClickListener;
    }

    @NonNull
    @Override
    public PropertyTypeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property_type, viewGroup, false);
        return new PropertyTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyTypeViewHolder propertyTypeViewHolder, int i) {
        PropertyType propertyType = propertyTypes.get(i);

        propertyTypeViewHolder.tv_pt_name.setText(propertyType.getName());

        switch (propertyType.getType()){
            case 1:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.home);
                break;
            case 2:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.apartments);
                break;
            case 3:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.villas);
                break;
            case 4:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.plots);
                break;
            case 5:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.agri);
                break;
            case 6:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.ventures);
                break;
            case 7:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.lease);
                break;
            case 8:
                propertyTypeViewHolder.iv_pt_icon.setImageResource(R.drawable.commercial);
                break;
        }

        propertyTypeViewHolder.iv_pt_icon.setOnClickListener(view -> onActionClickListener.onItemClickListener(i,propertyType));

    }

    @Override
    public int getItemCount() {
        return propertyTypes.size();
    }


    public class PropertyTypeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_pt_name;

        private ImageView iv_pt_icon;

        public PropertyTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_pt_name = itemView.findViewById(R.id.tv_name);
            iv_pt_icon = itemView.findViewById(R.id.iv_type);
        }
    }

}
