package com.vk.housing.authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vk.housing.Injection;
import com.vk.housing.R;
import com.vk.housing.data.remote.dao.SignupResponse;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSignup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSignup extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSignup() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSignup.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSignup newInstance(String param1, String param2) {
        FragmentSignup fragment = new FragmentSignup();
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
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        view.findViewById(R.id.btn_signup).setOnClickListener(view1 -> {

            Map<String,String> signupMap = new HashMap<>();
            signupMap.put("name", Util.getString(view.findViewById(R.id.et_name)));
            signupMap.put("phone", Util.getString(view.findViewById(R.id.et_phone)));
            signupMap.put("email_id", Util.getString(view.findViewById(R.id.et_email)));
            signupMap.put("password", Util.getString(view.findViewById(R.id.et_password)));
            signupMap.put("login_type","1");
            signupMap.put("otp","124");

            Injection.housingRepository(getContext()).signup(signupMap, new ResultCallBackListener() {
                @Override
                public void onSuccess(Object o) {
                    SignupResponse signupResponse = (SignupResponse) o;
                    Util.setUser(getActivity(),signupResponse.getUser());
                    navController.navigate(R.id.action_fragmentSignup_to_fragmentOtp);
                }
                @Override
                public void onFailure(Object o) {
                    String s = (String) o;
                    Util.showError(getActivity(),s);
                }
            });
        });

        view.findViewById(R.id.tv_already_login).setOnClickListener(view1 -> {
            navController.navigate(R.id.action_fragmentSignup_to_fragmentLogin);
        });
    }
}