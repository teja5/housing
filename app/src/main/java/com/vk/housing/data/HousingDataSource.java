package com.vk.housing.data;

import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

public interface HousingDataSource {

    void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener);

    void login(Map<String, String> loginMap, ResultCallBackListener resultCallBackListener);

    void forgotPassword(Map<String, String> forgotMap, ResultCallBackListener resultCallBackListener);

    void resetPassword(Map<String, String> resetMap, ResultCallBackListener resultCallBackListener);

    void addProperty(Map<String,String> propertyMap,ResultCallBackListener resultCallBackListener);

    void updateProperty(Map<String,String> propertyMap,ResultCallBackListener resultCallBackListener);

    void addFavourite(Map<String,String> favouriteMap,ResultCallBackListener resultCallBackListener);

    void getUserFavouriteProperties(Map<String,String> userFavouriteMap, ResultCallBackListener resultCallBackListener);

    void getPropertiesList(Map<String,String> propertyMap, ResultCallBackListener resultCallBackListener);

    void getPropertyById(Map<String,String> propertyMap,ResultCallBackListener resultCallBackListener);

    void deleteProperty(Map<String,String> deletePropertyMap, ResultCallBackListener resultCallBackListener);

    void uploadImage(long property_id, String filepath, ResultCallBackListener resultCallBackListener);

    void favouriteProperty(int f_id,int user_id,int property_id, ResultCallBackListener resultCallBackListener);

    void uploadImage(String filepath, ResultCallBackListener resultCallBackListener);

}
