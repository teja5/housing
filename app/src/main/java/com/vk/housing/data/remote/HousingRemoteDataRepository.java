package com.vk.housing.data.remote;

import android.util.Log;

import com.vk.housing.data.HousingDataSource;
import com.vk.housing.data.remote.dao.FavouriteResponse;
import com.vk.housing.data.remote.dao.LoginResponse;
import com.vk.housing.data.remote.dao.PropertyListResponse;
import com.vk.housing.data.remote.dao.PropertyResponse;
import com.vk.housing.data.remote.dao.SignupResponse;
import com.vk.housing.util.ResultCallBackListener;
import com.vk.housing.welcome.Dealer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
                    } else {
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

        housingApiInterface.login(loginMap.get("user"), loginMap.get("password")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Log.d("response", call.toString());
                if (response.isSuccessful()) {

                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getStatus() == 202) {
                        resultCallBackListener.onSuccess(response.body());
                    } else {
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
                    } else {
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

    @Override
    public void addProperty(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

        housingApiInterface.addProperty(propertyMap).enqueue(new Callback<PropertyResponse>() {
            @Override
            public void onResponse(Call<PropertyResponse> call, Response<PropertyResponse> response) {

                if (response.isSuccessful()) {

                    Log.d("Response", response.toString());

//                    LoginResponse loginResponse = response.body();
//
//                    if (loginResponse.getStatus() == 202) {
//                        resultCallBackListener.onSuccess(response.body());
//                    }else {
//                        resultCallBackListener.onFailure(loginResponse.getError().getErrorMessage());
//                    }

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
            public void onFailure(Call<PropertyResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });

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
        housingApiInterface.listProperty(Integer.parseInt(propertyMap.get("firstResult")), Integer.parseInt(propertyMap.get("max"))).enqueue(new Callback<PropertyListResponse>() {
            @Override
            public void onResponse(Call<PropertyListResponse> call, Response<PropertyListResponse> response) {

                if (response.isSuccessful()) {

                    PropertyListResponse propertyListResponse = response.body();

                    resultCallBackListener.onSuccess(propertyListResponse);
                } else {
//                        resultCallBackListener.onFailure(loginResponse.getError().getErrorMessage());
                }

//                } else {
//                    switch (response.code()) {
//                        case 401:
//                            resultCallBackListener.onFailure("Unauthorized");
//                            break;
//                        case 404:
//                            resultCallBackListener.onFailure("Not Found");
//                            break;
//                        case 500:
//                            resultCallBackListener.onFailure("No Response from server");
//                            break;
//                        default:
//                            resultCallBackListener.onFailure("Unknown Error");
//                            break;
//                    }
//                }

            }

            @Override
            public void onFailure(Call<PropertyListResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }

    @Override
    public void uploadImage(long property_id, String filepath, ResultCallBackListener resultCallBackListener) {
//        File file = new File(filepath);
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpeg"),
                new File(filepath));
        housingApiInterface.uploadPhoto(property_id, reqFile).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d("Sucess", "Sucess");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("Failure", "Fslse");

            }
        });
    }

    @Override
    public void getPropertyById(Map<String, String> propertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void deleteProperty(Map<String, String> deletePropertyMap, ResultCallBackListener resultCallBackListener) {

    }

    @Override
    public void favouriteProperty(int f_id, int user_id, int property_id, ResultCallBackListener resultCallBackListener) {

        housingApiInterface.favouriteProperty(f_id, user_id, property_id).enqueue(new Callback<FavouriteResponse>() {
            @Override
            public void onResponse(Call<FavouriteResponse> call, Response<FavouriteResponse> response) {

                if (response.isSuccessful()) {
                    FavouriteResponse favouriteResponse = response.body();
                    resultCallBackListener.onSuccess(favouriteResponse);
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
            public void onFailure(Call<FavouriteResponse> call, Throwable t) {
                resultCallBackListener.onFailure("Could not connect to server please try again");
            }
        });
    }

    @Override
    public void uploadImage(String filepath, ResultCallBackListener resultCallBackListener) {

        RequestBody reqFile = RequestBody.create(MediaType.parse("image/jpeg"),
                new File(filepath));

        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), "121");

        RequestBody bodyFile = RequestBody.create(MediaType.parse("multipart/form-data"), new File(filepath));

        MultipartBody.Part partImage = MultipartBody.Part.createFormData("image",filepath,bodyFile);

        ArrayList<MultipartBody.Part> parts = new ArrayList<>();
        parts.add(partImage);
        parts.add(partImage);

//        Map<String, RequestBody> params = new HashMap<>();
//        params.put("user_id",body);
//        params.put("image",reqFile);

//        housingApiInterface.uploadPhotoTest1(params).enqueue(new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//
//                try {
//
//                    Log.d("Response" , " " + response.errorBody().toString() );
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//
//            }
//        });

        housingApiInterface.uploadPhotoTest(body,parts).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {

                    Log.d("Response" , " " + response.errorBody().toString() );

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("Failure", "Fslse" + t.getMessage());

            }
        });

    }
}
