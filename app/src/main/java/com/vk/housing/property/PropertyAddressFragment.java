package com.vk.housing.property;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.util.Util;

import java.util.HashMap;

public class PropertyAddressFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "property_id";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private NavController navController;

    public PropertyAddressFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PropertyAddressFragment newInstance(String param1, String param2) {
        PropertyAddressFragment fragment = new PropertyAddressFragment();
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
        return inflater.inflate(R.layout.fragment_property_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);
        view.findViewById(R.id.btn_next).setOnClickListener(v -> {
            navController.navigate(R.id.action_propertyAddressFragment_to_propertyImagesFragment);

            Log.d("Property", mParam1 + "");
            EditText et_city = view.findViewById(R.id.et_city);
            EditText et_name_a = view.findViewById(R.id.et_name_a);
            EditText et_locality = view.findViewById(R.id.et_locality);
            EditText et_address = view.findViewById(R.id.et_address);

            HashMap<String, String> propertyHashMap = new HashMap<>();
            propertyHashMap.put("property_id", mParam1);
            propertyHashMap.put("city", Util.getString(et_city));
            propertyHashMap.put("name", Util.getString(et_name_a));
            propertyHashMap.put("locality", Util.getString(et_locality));
            propertyHashMap.put("address", Util.getString(et_address));

//            updateProperty(propertyHashMap);

        });

    }

    void updateProperty(HashMap<String, String> propertyHashMap) {
        Injection.housingRepository(getActivity()).updateProperty(propertyHashMap, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                navController.navigate(R.id.action_propertyAddressFragment_to_propertyImagesFragment);
            }

            @Override
            public void onFailure(Object o) {

            }
        });

    }
}