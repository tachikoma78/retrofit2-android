package com.google.retrofittutorial;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pierre Vanderpol on 2018-09-27.
 */

public interface Api {

    @GET("/Posts")
    Call<ResponseBody> getPosts();


    @GET("/Users")
    Call<ResponseBody> getUsers();

}
