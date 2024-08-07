package com.vk.housing.data;

import android.content.Context;

import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

public class HousingRepository implements HousingDataSource {

    public static HousingRepository housingRepository;

    private HousingDataSource housingDataSourceRemote;

    private Context context;

    public HousingRepository(HousingDataSource housingDataSourceRemote, Context context) {

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

    }

    @Override
    public void login(Map<String, String> loginMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void forgotPassword(Map<String, String> forgotMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void resetPassword(Map<String, String> resetMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void addProperty(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void updateProperty(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void addFavourite(Map<String, String> favouriteMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void getUserFavouriteProperties(Map<String, String> userFavouriteMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void getPropertiesList(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void getPropertyById(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void deleteProperty(Map<String, String> deletePropertyMap, ResultCallBackListener resultCallBackListener) {

    }


    @Override
    public void uploadImage(long property_id, String filepath, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void favouriteProperty(int f_id, int user_id, int property_id, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void uploadImage(String filepath, ResultCallBackListener resultCallBackListener) {

    }
}