package com.neppplus.a20220526_dailyreport_retrofit.api

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIList {


    @FormUrlEncoded  // 파라미터 중에 폼데이터로 담아야하는 파라미터가 있다면 필요한 구문
    @POST("/user")  // retrofit이 POST라는 메쏘드로 적는구나
    fun postRequestLogin (
        @Field("email") email: String,
        @Field("password") pw: String
    ) : Call<JSONObject>

}