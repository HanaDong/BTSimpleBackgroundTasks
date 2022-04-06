package com.example.myapplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET("users")
    Call<ArrayList<User>> getAllUsers();
    @GET("users/{id}")
    Call<User> getUsersByID(@Path("id") int id);

    String token = "2e98a3fe5f2bca39fd5c79e14aa6942d1d091ec27106caf48d61d78684ff88b3";
    @POST("users?access-token=" + token)
    Call<User> addUser(@Body() User user);
}
