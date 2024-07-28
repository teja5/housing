package com.vk.housing.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.adapter.HomeAdapter;
import com.vk.housing.adapter.HomeFragmentAdapter;
import com.vk.housing.data.remote.dao.FavouriteResponse;
import com.vk.housing.data.remote.dao.Property;
import com.vk.housing.data.remote.dao.PropertyListResponse;
import com.vk.housing.util.OnItemClickListener;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment implements OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rv_properties;
    HomeAdapter homeAdapter;
    ArrayList<Property> properties;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_properties = view.findViewById(R.id.rv_properties);
        rv_properties.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false));
        properties = new ArrayList<>();
        Property property = new Property();
        property.setpAddress("Hydearabad");
        properties.add(property);
        Property property1 = new Property();
        property1.setpAddress("Vijayawada");
        properties.add(property1);
        homeAdapter = new HomeAdapter(properties, getActivity(), this);
        rv_properties.setAdapter(homeAdapter);

        ViewPager viewPager = view.findViewById(R.id.pager_view);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = view.findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getNearByProperties();
    }

    //TODO Replace Nearby Properties
    void getNearByProperties() {
        HashMap<String, String> getList = new HashMap<>();
        getList.put("firstResult", "0");
        getList.put("max", "10");
        Injection.housingRepository(getActivity()).getPropertiesList(getList, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {

                PropertyListResponse propertyListResponse = (PropertyListResponse) o;
                Log.d("PropertyList", propertyListResponse.getPropertyList().size() + "");

                properties = new ArrayList<>();
                for (Property property : propertyListResponse.getPropertyList()) {
                    properties.add(property);
                }
                homeAdapter = new HomeAdapter(properties, getActivity(), FragmentHome.this::onItemClickListener);
                rv_properties.setAdapter(homeAdapter);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        HomeFragmentAdapter adapter = new HomeFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentBuy(), "Buy");
        adapter.addFragment(new FragmentRent(), "Rent");
        adapter.addFragment(new FragmentCommercial(), "Commercial");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onItemClickListener(int position, Property property) {

        if (position == -1) {

            Injection.housingRepository(getActivity()).favouriteProperty(0, Util.getUser(getContext()).getUserId(), property.getPropertyId(), new ResultCallBackListener() {
                @Override
                public void onSuccess(Object o) {
                    FavouriteResponse favouriteResponse = (FavouriteResponse) o;
                    Log.d("Favaourite", favouriteResponse.getStatus().toString());
                }

                @Override
                public void onFailure(Object o) {

                }
            });

        } else {
            Intent intent = new Intent(getActivity(), PropertyDetailsActivity.class);
            startActivity(intent);
        }
    }
}