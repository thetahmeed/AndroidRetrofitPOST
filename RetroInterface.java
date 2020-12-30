package com.tahmeedul.androidretrofitpost;

import com.tahmeedul.androidretrofitpost.getpost.PostArray;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroInterface {

    // 1. pushing data as JSON format
    @POST("posts")
    Call<PostArray> createPost(@Body PostArray postArray);

    // 2. pushing data as UrlEncoded
    @FormUrlEncoded
    @POST("posts")
    Call<PostArray> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );

    // 2.1 pushing data as UrlEncoded with Map
    @FormUrlEncoded
    @POST("posts")
    Call<PostArray> createPost(@FieldMap Map<String, String> fields);

}
