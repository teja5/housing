package com.vk.housing.data.remote;

import com.vk.housing.data.HousingDataSource;
import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HousingRemoteDataRepository implements HousingDataSource {

    public static HousingRemoteDataRepository housingRemoteDataRepository;

    private HousingApiInterface housingApiInterface;

    public static HousingRemoteDataRepository getInstance(HousingApiInterface housingApiInterface) {
        if (housingRemoteDataRepository == null) {
            housingRemoteDataRepository = new HousingRemoteDataRepository(housingApiInterface);
        }
        return housingRemoteDataRepository;
    }

    private HousingRemoteDataRepository(HousingApiInterface housingApiInterface) {
        this.housingApiInterface = housingApiInterface;
    }

    @Override
    public void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener) {
        housingApiInterface.signUp(signUpMap).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }
}
