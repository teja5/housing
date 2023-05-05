package com.vk.housing.data.remote;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface HousingApiInterface {

    // signup call
    @POST("user/signup")
    Call<Object> signUp(@Body Map<String, String> signupData);

    // login call
    @GET("user/login")
    Call<Object> login(@Body Map<String, String> loginData);

    // forgot password call
    @GET("user/forgot_password")
    Call<Object> forgotPassword(@Body Map<String, String> forgotPasswordData);

    // update password call
    @GET("user/updatePassword")
    Call<Object> updatePassword(@Body Map<String, String> updatePasswordData);

//
//    // Reset call first Login
//    @PUT("users/reset_firstlogin")
//    Call<LoginResponse> reset_first_login(@Body Map<String, String> loginData);
//
//    // Registration call
//    @POST("users/register")
//    Call<RegistrationResponse> register(@Body Map<String, String> registerData);
//
//    @POST("/users/resend")
//    Call<RegistrationResponse> resendMail(@Body Map<String, String> resendMail);
//
//    // Get User Details
//    @GET("users/user_details")
//    Call<UserDetailResponse> getUserDetails(@Header("Authorization") String token);
//
//    // Get Profile Details
//    @GET("users/profile_details")
//    Call<ProfileDetailResponse> getProfileDetails(@Header("Authorization") String token);
//
//    // Get Profile Details
//    @GET("users/tz")
//    Call<List<TimeZone>> getTimeZones();
//
//    // Get Countries
//    @GET("users/country")
//    Call<List<Location>> getCountries();
//
//    // Post Change Password
//    @POST("users/changepwd")
//    Call<LoginResponse> changePassword(@Body Map<String, String> changePasswordMap, @Header("Authorization") String token);
//
//    // Save User Details  first Login
//    @POST("users/save_mydetails")
//    Call<ProfileDetailResponse> saveUserDetails(@Body Map<String, Object> userUpdate, @Header("Authorization") String token);
//
//    // Change Email
//    @POST("users/resendemailchange")
//    Call<EmailChangeResponse> changeEmail(@Body Map<String, String> changeEmailData, @Header("Authorization") String token);
//
//    //Update Matrix Details
//    @POST("users/save_matrix")
//    Call<ProfileDetailResponse> updateMatrixChanges(@Body Map<String, Object> matrixChanges, @Header("Authorization") String token);
//
//    @POST("users/addchecklist")
//    Call<UserDetailResponse> addCheckList(@Header("Authorization") String token, @Body Map<String, String> addCheckList);
//
//    @POST("users/editchecklist")
//    Call<UserDetailResponse> editCheckList(@Header("Authorization") String token, @Body Map<String, String> editCheckList);
//
//    @POST("users/deletechecklist")
//    Call<UserDetailResponse> deleteCheckList(@Header("Authorization") String token, @Body Map<String, String> deleteCheckList);
//
//    @POST("users/addproject")
//    Call<UserDetailResponse> addProject(@Header("Authorization") String token, @Body Map<String, String> addProject);
//
//    @POST("users/editproject")
//    Call<UserDetailResponse> updateProject(@Header("Authorization") String token, @Body Map<String, String> editProject);
//
//    @POST("users/deleteproject")
//    Call<UserDetailResponse> deleteProject(@Header("Authorization") String token, @Body Map<String, String> deleteProject);
//
//    @POST("users/newfolder")
//    Call<UserDetailResponse> addNewFolder(@Header("Authorization") String token, @Body Map<String, String> newFolderList);
//
//    @POST("users/editfolder")
//    Call<UserDetailResponse> editFolder(@Header("Authorization") String token, @Body Map<String, String> editFolder);
//
//    @POST("users/deletefolder")
//    Call<UserDetailResponse> deleteSubProject(@Header("Authorization") String token, @Body Map<String, String> deleteFolder);
//
//    @POST("users/projectexist")
//    Call<UserDetailResponse> checkProjectExists(@Header("Authorization") String token, @Body Map<String, String> proejctExists);
//
//    @POST("users/checklistexist")
//    Call<UserDetailResponse> checkListExists(@Header("Authorization") String token, @Body Map<String, String> checkListExists);
//
//    @POST("users/save_notify")
//    Call<UserDetailResponse> updateNotify(@Header("Authorization") String token, @Body Map<String, Object> checkListExists);
//
//    @POST("checklists/addofftodo")
//    Call<UserDetailResponse> addTodoList(@Header("Authorization") String token, @Body Map<String, Object> addCheckList);
//
//    @POST("checklists/editofftodo")
//    Call<UserDetailResponse> editTodoList(@Header("Authorization") String token, @Body Map<String, Object> addCheckList);
//
//    @POST("checklists/delete")
//    Call<UserDetailResponse> deleteTodoList(@Header("Authorization") String token, @Body Map<String, String> addCheckList);
//
//    @GET("tasks/list/{uID}")
//    Call<TasksResponse> getAllTasks(@Header("Authorization") String token, @Path("uID") String user_id);
//
//    @POST("tasks/add")
//    Call<TaskResponse> addTask(@Header("Authorization") String token, @Body Map<String, Object> addTaskMap);
//
//    @POST("tasks/edit")
//    Call<TaskResponse> editTask(@Header("Authorization") String token, @Body Map<String, Object> addTaskMap);
//
//    @POST("tasks/name")
//    Call<TaskNameResponse> editTaskTitle(@Header("Authorization") String token, @Body Map<String, String> addTaskMap);
//
//    @POST("tasks/complete")
//    Call<TasksResponse> completeTask(@Header("Authorization") String token, @Body Map<String, Object> addTaskMap);
//
//    @POST("tasks/empty_completed")
//    Call<TasksResponse> emptyCompleteTasks(@Header("Authorization") String token, @Body Map<String, String> addTaskMap);
//
//    @POST("tasks/trash")
//    Call<TasksResponse> deleteTrashTasks(@Header("Authorization") String token, @Body Map<String, String> addTaskMap);
//
//    @POST("tasks/editdelegate")
//    Call<TaskResponse> editDelegate(@Header("Authorization") String token, @Body Map<String, String> editDelegateMap);
//
//    @POST("tasks/deletedelegate")
//    Call<TaskResponse> deleteDelegate(@Header("Authorization") String token, @Body Map<String, String> deleteDelegateMap);
//
//    @GET("checklists/alltodos/{uID}")
//    Call<CheckListItemResponse> getCheckList(@Header("Authorization") String token, @Path("uID") String user_id);
//
//    @POST("tasks/addoff")
//    Call<TasksResponse> addOfflineTasks(@Header("Authorization") String token, @Body Map<String, Object> addOfflineTask);
//
//    @POST("tasks/editoff")
//    Call<TasksResponse> addOfflineEditedTasks(@Header("Authorization") String token, @Body Map<String, Object> addEditOfflineTasks);
//
//    @POST("tasks/rem")
//    Call<ReminderResponse> updateTaskReminder(@Header("Authorization") String token, @Body Map<String, Object> reminderActionMap);
//
//    @GET("users/country_pricing_details")
//    Call<CurrencyResponse> getPricingDetails();
//
//    @GET("users/country_pricing_details")
//    Call<PricesResponse> getPriceDetailsNew();
//
//    @GET("users/verify/{token}")
//    Call<CurrencyResponse> verifyUser(@Path("token") String token);
//
//    @POST("users/resetpwd")
//    Call<CurrencyResponse> resetPasswordChange(@Body Map<String, String> resetMap);
//
//    @POST("users/foldertoother")
//    Call<UserDetailResponse> moveFolderToAnotherProject(@Header("Authorization") String token, @Body Map<String, Object> moveProjectMap);
//
//    @POST("supports/add")
//    Call<LoginResponse> supportApi(@Header("Authorization") String token, @Body Map<String, Object> supportMap);
//
//    @POST("users/app_txn")
//    Call<LoginResponse> subscriptionPlan(@Header("Authorization") String token, @Body Map<String, Object> transactionMAp);
//
//    @POST("users/forgotpwd")
//    Call<RegistrationResponse> forgetPassword(@Body Map<String, Object> transactionMAp);
//
//    @GET
//    Call<CurrencyResponse> getSendGrid(@Url String url);
//
//    @POST("users/expirynoti")
//    Call<RegistrationResponse> updateSkip(@Header("Authorization") String token, @Body Map<String, String> skipMap);
//
//    @POST("tasks/senddelegateemail")
//    Call<MailResponse> sendMail(@Header("Authorization") String token, @Body Map<String, Object> sendMailMap);
//
//    @GET("users/tracker")
//    Call<TrackerResponse> tracker(@Header("Authorization") String token);
}