package com.vk.housing.data.remote;

import android.util.Log;

import com.vk.housing.data.HousingDataSource;
import com.vk.housing.data.remote.dao.LoginResponse;
import com.vk.housing.data.remote.dao.SignupResponse;
import com.vk.housing.util.ResultCallBackListener;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HousingRemoteDataRepository implements HousingDataSource {

    public static HousingRemoteDataRepository housingRemoteDataRepository;

    private final HousingApiInterface housingApiInterface;

    private HousingRemoteDataRepository(HousingApiInterface housingApiInterface) {
        this.housingApiInterface = housingApiInterface;
    }

    public static HousingRemoteDataRepository getInstance(HousingApiInterface housingApiInterface) {
        if (housingRemoteDataRepository == null) {
            housingRemoteDataRepository = new HousingRemoteDataRepository(housingApiInterface);
        }
        return housingRemoteDataRepository;
    }

    @Override
    public void signup(Map<String, String> signUpMap, ResultCallBackListener resultCallBackListener) {
        housingApiInterface.signUp(signUpMap).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                if (response.isSuccessful()) {

                    SignupResponse signupResponse = response.body();
                    if (signupResponse.getStatus() == 202) {
                        resultCallBackListener.onSuccess(response.body());
                    }else {
                        resultCallBackListener.onFailure(signupResponse.getError().getErrorMessage());
                    }

                } else {
                    switch (response.code()) {
                        case 401:
                            resultCallBackListener.onFailure("Unauthorized");
                            break;
                        case 404:
                            resultCallBackListener.onFailure("Not Found");
                            break;
                        case 500:
                            resultCallBackListener.onFailure("No Response from server");
                            break;
                        default:
                            resultCallBackListener.onFailure("Unknown Error");
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }

    @Override
    public void login(Map<String, String> loginMap, ResultCallBackListener resultCallBackListener) {

        housingApiInterface.login(loginMap.get("user"),loginMap.get("password")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Log.d("response",call.toString());
                if (response.isSuccessful()) {

                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getStatus() == 202) {
                        resultCallBackListener.onSuccess(response.body());
                    }else {
                        resultCallBackListener.onFailure(loginResponse.getError().getErrorMessage());
                    }

                } else {
                    switch (response.code()) {
                        case 401:
                            resultCallBackListener.onFailure("Unauthorized");
                            break;
                        case 404:
                            resultCallBackListener.onFailure("Not Found");
                            break;
                        case 500:
                            resultCallBackListener.onFailure("No Response from server");
                            break;
                        default:
                            resultCallBackListener.onFailure("Unknown Error");
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }

    @Override
    public void forgotPassword(Map<String, String> forgotMap, ResultCallBackListener resultCallBackListener) {

        housingApiInterface.forgotPassword(forgotMap.get("user")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {

                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getStatus() == 202) {
                        resultCallBackListener.onSuccess(response.body());
                    }else {
                        resultCallBackListener.onFailure(loginResponse.getError().getErrorMessage());
                    }

                } else {
                    switch (response.code()) {
                        case 401:
                            resultCallBackListener.onFailure("Unauthorized");
                            break;
                        case 404:
                            resultCallBackListener.onFailure("Not Found");
                            break;
                        case 500:
                            resultCallBackListener.onFailure("No Response from server");
                            break;
                        default:
                            resultCallBackListener.onFailure("Unknown Error");
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }

    @Override
    public void resetPassword(Map<String, String> resetMap, ResultCallBackListener resultCallBackListener) {

    }
}
