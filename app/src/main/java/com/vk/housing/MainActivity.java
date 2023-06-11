package com.vk.housing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vk.housing.home.FragmentAdd;
import com.vk.housing.home.FragmentHome;
import com.vk.housing.home.FragmentProfile;
import com.vk.housing.search.SearchActivity;
import com.vk.housing.home.StatusActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mn_status) {
            Intent statusIntent = new Intent(MainActivity.this, StatusActivity.class);
            startActivity(statusIntent);
            // Do something
            return true;
        }
        if (id == R.id.mn_search) {
            Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(searchIntent);
            // Do something
            return true;
        }

        if (id == R.id.mn_notification) {

            // Do something
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}