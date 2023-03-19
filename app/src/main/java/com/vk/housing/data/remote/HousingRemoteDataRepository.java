package com.vk.housing.data.remote;

import com.vk.housing.data.HousingDataSource;

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
}
