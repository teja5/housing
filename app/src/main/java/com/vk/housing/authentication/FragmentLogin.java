package com.vk.housing.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.vk.housing.Injection;
import com.vk.housing.MainActivity;
import com.vk.housing.R;
import com.vk.housing.data.remote.dao.LoginResponse;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.util.Util;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLogin.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.btn_next).setOnClickListener(view1 -> {

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
//            HashMap<String, String> loginMap = new HashMap<>();
//            loginMap.put("user", Util.getString(view.findViewById(R.id.et_email)));
//            loginMap.put("password", Util.getString(view.findViewById(R.id.et_password)));
//            Injection.housingRepository(getActivity()).login(loginMap, new ResultCallBackListener() {
//                @Override
//                public void onSuccess(Object o) {
//
//                    LoginResponse loginResponse = (LoginResponse) o;
//                    Util.setUser(getActivity(), loginResponse.getUser());
//                    Intent intent = new Intent(getActivity(), MainActivity.class);
//                    startActivity(intent);
//                    getActivity().finish();
//                }
//
//                @Override
//                public void onFailure(Object o) {
//                    String s = (String) o;
//                    Util.showError(getActivity(), s);
//                }
//            });
        });

        view.findViewById(R.id.tv_sign_up).setOnClickListener(view1 -> {
            navController.navigate(R.id.action_fragmentLogin_to_fragmentSignup);
        });

        view.findViewById(R.id.tv_forgot_password).setOnClickListener(view1 -> {
            navController.navigate(R.id.action_fragmentLogin_to_fragmentForgetPassword);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}