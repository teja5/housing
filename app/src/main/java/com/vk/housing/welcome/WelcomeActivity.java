package com.vk.housing.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.vk.housing.R;
import com.vk.housing.authentication.AuthenticationActivity;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewPager2 = findViewById(R.id.viewpager);
        btn_next = findViewById(R.id.btn_next);

        ArrayList<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("one"));
        sliderItems.add(new SliderItem("two"));
        sliderItems.add(new SliderItem("three"));
        sliderItems.add(new SliderItem("four"));
        SliderAdapter sliderAdapter = new SliderAdapter(this, sliderItems);
        viewPager2.setAdapter(sliderAdapter);

        btn_next.setOnClickListener(view -> {
            Intent intent = new Intent(this, AuthenticationActivity.class);
            startActivity(intent);
        });
    }
}
