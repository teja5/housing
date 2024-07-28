package com.vk.housing.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.vk.housing.MainActivity;
import com.vk.housing.R;
import com.vk.housing.authentication.AuthenticationActivity;
import com.vk.housing.util.OnActionClickListener;
import com.vk.housing.util.Util;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity implements OnActionClickListener {

    ViewPager2 viewPager2;

    Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        viewPager2 = findViewById(R.id.viewpager);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setVisibility(View.GONE);

        ArrayList<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("Find the home of your " +
                "Dreams","Your one click destination to find your dream home around the corner."));
        sliderItems.add(new SliderItem("Perfect choice for your\n" +
                "Future","Our Properties of masterpiece for everyone with\n" +
                "long lasting value.\n"));
        sliderItems.add(new SliderItem("Explore latest properties\n" +
                "in your Neighbourhood","Checkout new projects, Rents, Buy & Sell of your choice and more"));
        SliderAdapter sliderAdapter = new SliderAdapter(this, sliderItems, this);
        viewPager2.setAdapter(sliderAdapter);

        btn_next.setOnClickListener(view -> {
            Intent intent = new Intent(this, AuthenticationActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Util.getUser(this) != null && Util.getUser(getApplication()).getUserId().toString().length() != 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onItemClickListener(int position, Object o) {
        if (position == 1) {
            moveToAuthentication();
        } else if (position == 2) {
            if (viewPager2.getCurrentItem() <= 1) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            } else {
                moveToAuthentication();
            }
        }
    }

    private void moveToAuthentication() {
        Intent intent = new Intent(this, AuthenticationActivity.class);
        startActivity(intent);
        finish();
    }
}
