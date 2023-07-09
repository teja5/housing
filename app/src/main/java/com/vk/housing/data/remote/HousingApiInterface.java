package com.vk.housing.data.remote;


import com.vk.housing.data.remote.dao.FavouriteResponse;
import com.vk.housing.data.remote.dao.LoginResponse;
import com.vk.housing.data.remote.dao.PropertyListResponse;
import com.vk.housing.data.remote.dao.PropertyResponse;
import com.vk.housing.data.remote.dao.SignupResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface HousingApiInterface {

    // signup call
    @POST("user/signup")
    Call<SignupResponse> signUp(@Body Map<String, String> signupData);

    // login call
    @GET("user/login")
    Call<LoginResponse> login(@Query("user") String user,@Query("password") String password);

    // forgot password call
    @GET("user/forgot_password")
    Call<LoginResponse> forgotPassword(@Query("user") String user);

    // update password call
    @GET("user/updatePassword")
    Call<Object> updatePassword(@Body Map<String, String> updatePasswordData);

    @GET("property/listProperty")
    Call<PropertyListResponse> listProperty(@Query("firstResult") int firstResult,@Query("max") int max);

    //TODO Nearby popular
//    @GET("property/listProperty")
//    Call<PropertyListResponse> listProperty(@Query("firstResult") int firstResult,@Query("max") int max);

    //TODO GetLocations by location
//    @GET("property/listProperty")
//    Call<PropertyListResponse> listProperty(@Query("firstResult") int firstResult,@Query("max") int max);

    //TODO GetLocations by location category
//    @GET("property/listProperty")
//    Call<PropertyListResponse> listProperty(@Query("firstResult") int firstResult,@Query("max") int max);

    //TODO filter search
//    @GET("property/listProperty")
//    Call<PropertyListResponse> listProperty(@Query("firstResult") int firstResult,@Query("max") int max);

    @GET("property/savedpropertesbyuser")
    Call<PropertyListResponse> savedPropertiesByUser(@Query("userId") int user_id,@Query("firstResult") int firstResult,@Query("max") int max);


    @POST("property/add")
    Call<PropertyResponse> addProperty(@Body Map<String, String> propertyData);

    @PUT("property/update")
    Call<PropertyResponse> updateProperty(@Body Map<String, String> propertyData);

    @POST("property/favourite")
    Call<FavouriteResponse> favouriteProperty(@Query("psp_id") int favourite_id,@Query("psc_id") int user_id,@Query("ps_id") int  property_id);

    // update User Details
    @PUT("user/editProfile")
    Call<LoginResponse> updateDetails(@Query("userId") int userId,@Query("username") String name,@Query("mailid") int mail_id,@Query("phone") int phone);

    @Multipart
    @POST("property/uploadPropertyImage")
    Call<Object> uploadPhoto(@Part("propertyId") String propertyId, @Part("image") MultipartBody.Part imageFile);

}