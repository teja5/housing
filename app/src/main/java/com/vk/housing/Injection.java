package com.vk.housing;

import android.content.Context;

import com.vk.housing.data.remote.HousingApiInterface;
import com.vk.housing.data.remote.HousingClient;
import com.vk.housing.data.remote.HousingRemoteDataRepository;
import com.vk.housing.data.remote.HousingRepository;

public class Injection {

    public static HousingRepository housingRepository;

    public static HousingRepository housingRepository(Context context) {
        if (housingRepository == null) {

            HousingApiInterface housingApiInterface = HousingClient.getClient().create(HousingApiInterface.class);

            HousingRemoteDataRepository housingRemoteDataRepository = HousingRemoteDataRepository.getInstance(housingApiInterface);

            housingRepository = HousingRepository.getInstance(housingRemoteDataRepository, context);
        }
        return housingRepository;
    }
}
