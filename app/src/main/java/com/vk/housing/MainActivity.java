package com.vk.housing;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vk.housing.home.FragmentAdd;
import com.vk.housing.home.FragmentHome;
import com.vk.housing.home.FragmentProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.mn_name:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.mn_add:
                    selectedFragment = new FragmentAdd();

                    break;
                case R.id.mn_profile:
                    selectedFragment = new FragmentProfile();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        });
    }
}