package com.sun.surya;

/**
 * Created by Sanny on 6/21/2017.
 */

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {
    public static String userID = "8001";
   /* @GET("")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);*/

    @GET("/feed/"+userID+"?")
    Call<FeedData> doGetUserList(@Query("page") int page);

 /*   @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}