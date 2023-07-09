package com.vk.housing.property;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.util.Util;

import java.util.HashMap;

public class PropertyDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private NavController navController;

    public PropertyDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropertyDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropertyDetailsFragment newInstance(String param1, String param2) {
        PropertyDetailsFragment fragment = new
                PropertyDetailsFragment();
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
        return inflater.inflate(R.layout.fragment_property_details, container, false);
    }
    int property_type= 0, bhk =0, bathRoom = 0,balcony =0 ,furnishType =0, parking =0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        RadioGroup rg_for = (RadioGroup) view.findViewById(R.id.rg_property_for);
        RadioButton rb_sell = (RadioButton) view.findViewById(R.id.rb_sell);

        RadioGroup rg_building_type = (RadioGroup) view.findViewById(R.id.rg_building_type);
        RadioButton rb_residential = (RadioButton) view.findViewById(R.id.rb_residential);

        RadioGroup rg_property_type = (RadioGroup) view.findViewById(R.id.rg_building_type);
        rg_property_type.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_apartment:
                    property_type = 1;
                    break;
                case R.id.rb_residential:
                    property_type = 2;
                    break;
            }
        });

        RadioGroup rgConstructionStatus = (RadioGroup) view.findViewById(R.id.rg_construction_status);
        RadioButton rbReadyToMove =(RadioButton) view.findViewById(R.id.rb_ready_to_move);

        RadioGroup rg_bhk = (RadioGroup) view.findViewById(R.id.rg_bhk);
        rg_bhk.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_one_bhk:
                    bhk = 1;
                    break;
                case R.id.rb_two_bhk:
                    bhk = 2;
                    break;
            }
        });

        RadioGroup rgBathRoom = (RadioGroup) view.findViewById(R.id.rg_bathroom);
        rgBathRoom.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_one_bath:
                    bathRoom = 1;
                    break;
                case R.id.rb_two_bath:
                    bathRoom = 2;
                    break;
            }
        });

        RadioGroup rgBalcony = (RadioGroup) view.findViewById(R.id.rg_balcony);
        rgBalcony.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_one_balcony:
                    balcony = 1;
                    break;
                case R.id.rb_two_bath:
                    balcony = 2;
                    break;
            }
        });

        RadioGroup rgFurniture = (RadioGroup) view.findViewById(R.id.rg_furnish_type);
        rgFurniture.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_fully:
                    furnishType = 1;
                    break;
                case R.id.rb_semi:
                    furnishType = 2;
                    break;
            }
        });

        RadioGroup rgParking = (RadioGroup) view.findViewById(R.id.rg_parking);
        rgParking.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_one_parking:
                    parking = 1;
                    break;
                case R.id.rb_two_parking:
                    parking = 2;
                    break;
            }
        });

        view.findViewById(R.id.btn_address).setOnClickListener(v -> {

            int property_for = ((rg_for.getCheckedRadioButtonId() == rb_sell.getId()) ? 1 : 2);
            int building_type = ((rg_building_type.getCheckedRadioButtonId() == rb_residential.getId()) ? 1 : 2);
            int constructionStatus = ((rgConstructionStatus.getCheckedRadioButtonId() == rbReadyToMove.getId()) ? 1 : 2);



            HashMap<String, String> propertyMap = new HashMap<>();
            propertyMap.put("property_for", property_for + "");
            propertyMap.put("building_type", building_type + "");
            propertyMap.put("property_type", property_type + "");
            propertyMap.put("construction_status", constructionStatus + "");
            propertyMap.put("age_of_property", Util.getString(view.findViewById(R.id.et_age_of_property)));
            propertyMap.put("bhk", bhk +"");
            propertyMap.put("bath_room", bathRoom +"");
            propertyMap.put("balcony", balcony +"");
            propertyMap.put("furnish_type", furnishType +"");
            propertyMap.put("parking", parking +"");
            propertyMap.put("avalable", Util.getString(view.findViewById(R.id.et_available_from)));
            propertyMap.put("price", Util.getString(view.findViewById(R.id.et_price)));
            propertyMap.put("security", Util.getString(view.findViewById(R.id.et_security_deposit)));
            propertyMap.put("maintanace_charge", Util.getString(view.findViewById(R.id.et_maintenance)));
            propertyMap.put("built_area", Util.getString(view.findViewById(R.id.et_built_area)));
            propertyMap.put("carpet_area", Util.getString(view.findViewById(R.id.et_carpet_area)));
            propertyMap.put("offers_any", Util.getString(view.findViewById(R.id.et_comments)));
            propertyMap.put("p_address", "address");
            propertyMap.put("p_phone", "phone");
//            addProperty(propertyMap);
            Bundle bundle = new Bundle();
            bundle.putString("property_id",1+"");
            navController.navigate(R.id.action_propertyDetailsFragment_to_propertyAddressFragment,bundle);

        });
    }

    void addProperty(HashMap<String, String> propertyMap) {
        Injection.housingRepository(getActivity()).addProperty(propertyMap, new ResultCallBackListener() {
            @Override
            public void onSuccess(Object o) {
                Bundle bundle = new Bundle();
                bundle.putLong("property_id",1);
                navController.navigate(R.id.action_propertyDetailsFragment_to_propertyAddressFragment,bundle);
            }

            @Override
            public void onFailure(Object o) {

            }
        });
    }
}