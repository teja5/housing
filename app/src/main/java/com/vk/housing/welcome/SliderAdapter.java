package com.vk.housing.welcome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.housing.R;
import com.vk.housing.util.OnActionClickListener;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.MyViewHolder> {


    private final Context context;
    private final ArrayList<SliderItem> sliderItems;

    private final OnActionClickListener onActionClickListener;

    public SliderAdapter(Context context, ArrayList<SliderItem> sliderItems, OnActionClickListener onActionClickListener) {
        this.context = context;
        this.sliderItems = sliderItems;
        this.onActionClickListener = onActionClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(sliderItems.get(position).getTitle());
        holder.tvSliderOne.setText(sliderItems.get(position).getText());

        holder.btn_next.setOnClickListener(v -> {
            onActionClickListener.onItemClickListener(2,"");
        });
        holder.tvSkip.setOnClickListener(v -> {
            onActionClickListener.onItemClickListener(1,"");
        });
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvSliderOne, tvSkip;
        Button btn_next;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_slider_one);
            tvSliderOne = itemView.findViewById(R.id.tv_slider_two);
            tvSkip = itemView.findViewById(R.id.tv_skip);
            btn_next = itemView.findViewById(R.id.btn_next);

        }
    }
}