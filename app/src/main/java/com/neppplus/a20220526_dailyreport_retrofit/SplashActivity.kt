package com.neppplus.a20220526_dailyreport_retrofit

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.neppplus.a20220526_dailyreport_retrofit.Utils.ContextUtil
import com.neppplus.a20220526_dailyreport_retrofit.models.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {

    var isTokenOk = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        apiList.getRequestMainInfo(ContextUtil.getLoginUserToken(mContext))
            .enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {
                        isTokenOk = true
                    }
                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })
    }

    override fun setValues() {
        val myHandler = Handler(Looper.getMainLooper())
            myHandler.postDelayed({
                val myIntent : Intent
                val isAutoLoginOk = ContextUtil.getAutoLogin(mContext)
                isTokenOk

                if(isAutoLoginOk && isTokenOk ) {
                    myIntent = Intent(mContext, MainActivity :: class.java)
                } else {
                    myIntent = Intent(mContext, LoginActivity::class.java)
                }

                startActivity(myIntent)
                finish()

            },1500)

    }
}