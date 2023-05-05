package com.vk.housing.data;

import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

public interface HousingDataSource {

    void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener);

    void login(Map<String, String> loginMap, ResultCallBackListener resultCallBackListener);

    void forgotPassword(Map<String, String> forgotMap, ResultCallBackListener resultCallBackListener);

    void resetPassword(Map<String, String> resetMap, ResultCallBackListener resultCallBackListener);

}
