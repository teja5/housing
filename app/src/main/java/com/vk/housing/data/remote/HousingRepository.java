package com.vk.housing.data.remote;

import android.content.Context;

import com.vk.housing.data.HousingDataSource;
import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

public class HousingRepository implements HousingDataSource {

    public static HousingRepository housingRepository;

    private HousingDataSource housingDataSourceRemote;

    private Context context;


    public HousingRepository(HousingDataSource housingDataSourceRemote,  Context context) {
        this.housingDataSourceRemote = housingDataSourceRemote;
        this.context = context;
    }

    public static HousingRepository getInstance(HousingDataSource housingDataSourceRemote, Context context) {
        if (housingRepository == null) {
            housingRepository = new HousingRepository(housingDataSourceRemote, context);
        }
        return housingRepository;
    }

    @Override
    public void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener) {
        housingDataSourceRemote.signup(signUpMap,resultCallBackListener);
    }

    @Override
    public void login(Map<String, String> loginMap, ResultCallBackListener resultCallBackListener) {
        housingDataSourceRemote.login(loginMap,resultCallBackListener);
    }

    @Override
    public void forgotPassword(Map<String, String> forgotMap, ResultCallBackListener resultCallBackListener) {
        housingDataSourceRemote.forgotPassword(forgotMap,resultCallBackListener);
    }

    @Override
    public void resetPassword(Map<String, String> resetMap, ResultCallBackListener resultCallBackListener) {
        housingDataSourceRemote.resetPassword(resetMap,resultCallBackListener);
    }
}
