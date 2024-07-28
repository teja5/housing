package com.vk.housing.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vk.housing.R;
import com.vk.housing.adapter.HomeAdapter;
import com.vk.housing.adapter.PropertyTypeAdapter;
import com.vk.housing.data.remote.dao.PropertyType;
import com.vk.housing.util.OnActionClickListener;

import java.util.ArrayList;

public class FragmentBuy extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBuy() {
        // Required empty public constructor
    }

    RecyclerView rv_property_options;

    PropertyTypeAdapter propertyTypeAdapter;

    ArrayList<PropertyType> propertyTypes;

    // TODO: Rename and change types and number of parameters
    public static FragmentBuy newInstance(String param1, String param2) {
        FragmentBuy fragment = new FragmentBuy();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_buy, container, false);

        rv_property_options = view.findViewById(R.id.rv_property_options);
        rv_property_options.setLayoutManager(new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false));
        propertyTypes = new ArrayList<>();
        propertyTypes.add(new PropertyType(1,"Individual \nHouses"));
        propertyTypes.add(new PropertyType(2,"Apartments"));
        propertyTypes.add(new PropertyType(3,"Villas"));
        propertyTypes.add(new PropertyType(4,"Plots & \nVentures"));
        propertyTypes.add(new PropertyType(5,"Agriculture \nLands"));
        propertyTypes.add(new PropertyType(6,"Ventures"));
        propertyTypes.add(new PropertyType(7,"Lease \nShops"));
        propertyTypes.add(new PropertyType(8,"Commercial \nLands"));

        propertyTypeAdapter = new PropertyTypeAdapter(propertyTypes,getActivity(),(position, o) -> {

        });
        rv_property_options.setAdapter(propertyTypeAdapter);

        return  view;
    }
}