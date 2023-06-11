package com.vk.housing.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.vk.housing.R;
import com.vk.housing.adapter.HomeAdapter;
import com.vk.housing.data.remote.dao.Property;
import com.vk.housing.home.PropertyDetailsActivity;
import com.vk.housing.util.OnItemClickListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity  implements OnItemClickListener {

    RecyclerView rv_search;

    SearchAdapter searchAdapter;

    ArrayList<Property> properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rv_search = findViewById(R.id.rv_search);

        rv_search = findViewById(R.id.rv_search);
        rv_search.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
        properties = new ArrayList<>();
        Property property = new Property();
        property.setpAddress("Hydearabad");
        properties.add(property);
        Property property1 = new Property();
        property1.setpAddress("Vijayawada");
        properties.add(property1);
        searchAdapter = new SearchAdapter(properties, this, this);
        rv_search.setAdapter(searchAdapter);

    }

    @Override
    public void onItemClickListener(int position, Property property) {

        Intent intent = new Intent(this, PropertyDetailsActivity.class);
        startActivity(intent);
    }
}