package com.vk.housing.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.adapter.HomeAdapter;
import com.vk.housing.data.remote.dao.Property;
import com.vk.housing.data.remote.dao.PropertyListResponse;
import com.vk.housing.home.FragmentHome;
import com.vk.housing.home.PropertyDetailsActivity;
import com.vk.housing.util.OnItemClickListener;
import com.vk.housing.util.ResultCallBackListener;

import java.util.ArrayList;
import java.util.HashMap;

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
//        properties = new ArrayList<>();
//        Property property = new Property();
//        property.setpAddress("Hydearabad");
//        properties.add(property);
//        Property property1 = new Property();
//        property1.setpAddress("Vijayawada");
//        properties.add(property1);
//        searchAdapter = new SearchAdapter(properties, this, this);
//        rv_search.setAdapter(searchAdapter);

    }

    @Override
    public void onItemClickListener(int position, Property property) {

        Intent intent = new Intent(this, PropertyDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSearchProperties();
    }

    //TODO Search Properties
    void getSearchProperties() {
        HashMap<String, String> getList = new HashMap<>();
        getList.put("firstResult", "0");
        getList.put("max", "10");
        Injection.housingRepository(this).getPropertiesList(getList, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {

                PropertyListResponse propertyListResponse = (PropertyListResponse) o;
                Log.d("PropertyList", propertyListResponse.getPropertyList().size() + "");

                properties = new ArrayList<>();
                for (Property property : propertyListResponse.getPropertyList()) {
                    properties.add(property);
                }
                searchAdapter = new SearchAdapter(properties,SearchActivity.this , SearchActivity.this::onItemClickListener);
                rv_search.setAdapter(searchAdapter);

            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

}