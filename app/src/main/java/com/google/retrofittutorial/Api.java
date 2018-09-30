package com.google.retrofittutorial;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Pierre Vanderpol on 2018-09-27.
 */

public interface Api {

    @GET("/Posts")
    Call<ResponseBody> getPosts();


    @GET("/Users")
    Call<ResponseBody> getUsers();

    @POST("/users")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);

    @GET("/Users")
    Call<ResponseBody> getUsersByIds(@Query("id") List<Integer> ids);

    @GET("/posts")
    Call<ResponseBody> getPostsByUserId(@Query("userId") int userId);

    @GET("/posts")
    Call<ResponseBody> getPostsByUserIdAndPostId(@Query("userId") int userId, @Query("id") int postId);

    @GET("/posts")
    Call<ResponseBody> getPostsByIds(@Query("id") List<Integer> ids);

    @GET("/posts")
    Call<ResponseBody> getPostsByUserIdAndPostById(@Query("userId") String userId, @Query("id") String postId);

    @GET("/posts")
    Call<ResponseBody> getPostsByParams(@QueryMap Map<String, String>params);

    // More dynamic with path
    @GET("/posts/{id}")
    Call<ResponseBody> getPostById(@Path("id") int id);

    // Base URL
    @GET("https://api.ipify.org")
    Call<ResponseBody> getIp();

    @GET
    Call<ResponseBody> sendRequest(@Url String url);

    @Multipart
    @POST
    Call<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);

    @Multipart
    @POST
    Call<ResponseBody> ocr(@Url String url,
                          @Part("apikey") RequestBody apiKey,
                          @Part("language") RequestBody language,
                          @Part MultipartBody.Part part);



}

