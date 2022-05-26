package com.neppplus.a20220526_dailyreport_retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit 클래스를 객체화 함수
// 생성자를 쓰지 않고 굳이 객체화하는 이유 => API 통신은
//  => 단일 객체만 만들어서 모든 화면에서 공유
//  여러개의 객체를 만들 필요가 X => SingleTon 패턴
class ServerAPI {

        companion object {

//        서버 통신 담당 클래스 : 래트로핏 클래스 객체를 담을 변수
                private var retrofit : Retrofit? = null
                private var BASE_URL = "http://3.37.32.230"

                fun getRetrofit() : Retrofit {
                        if (retrofit == null) {
                                retrofit = Retrofit.Builder()
                                        .baseUrl(BASE_URL)  // 어느 서버를 기반으로 움직일 건지
                                        .addConverterFactory(GsonConverterFactory.create())  //gson 라이브러리와 결합
                                        .build()
                        }
                        return retrofit!!
                }

        }

}