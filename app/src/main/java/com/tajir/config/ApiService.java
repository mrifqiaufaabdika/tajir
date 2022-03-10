package com.tajir.config;


import com.tajir.respones.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    //get login
    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseAuth> auth(
            @Field("email") String email,
            @Field("password") String password
    );

}
