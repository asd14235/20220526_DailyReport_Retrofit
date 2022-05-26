package com.neppplus.a20220526_dailyreport_retrofit

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.a20220526_dailyreport_retrofit.api.APIList
import com.neppplus.a20220526_dailyreport_retrofit.api.ServerAPI

abstract class BaseActivity :AppCompatActivity() {

    lateinit var mContext : Context

//    모든 화면에서 apiList 변수가 있다면 => apiList.서버기능() 형태로 간단하게 코딩 가능
    lateinit var apiList : APIList

    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this

        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    abstract fun setupEvents()

    abstract fun setValues()
}