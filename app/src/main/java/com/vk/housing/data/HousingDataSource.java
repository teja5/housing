package com.vk.housing.data;

import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

public interface HousingDataSource {

    void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener);
}
