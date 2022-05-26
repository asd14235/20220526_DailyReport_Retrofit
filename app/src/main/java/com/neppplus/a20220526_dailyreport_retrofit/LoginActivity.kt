package com.neppplus.a20220526_dailyreport_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.neppplus.a20220526_dailyreport_retrofit.api.APIList
import com.neppplus.a20220526_dailyreport_retrofit.api.ServerAPI
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityLoginBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvent()
        setValues()
    }

    fun setupEvent() {

//        val inputEmail = binding.emailEdt.text.toString()
//        val inputPw = binding.passwordEdt.text.toString()

        val inputEmail = "kmc@kmc.com"
        val inputPw = "test!123"

        binding.loginBtn.setOnClickListener {

//            로그인 기능 (임시)  => BaseActivity로 옮겨서 모든화면에서
            val retrofit = ServerAPI.getRetrofit()
            val apiList = retrofit.create(APIList::class.java)

            apiList.postRequestLogin(inputEmail, inputPw).enqueue(object : Callback<JSONObject>{
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                    val br = response.toString()

                    if (response.isSuccessful) {
                        Log.d("서버 성공 응답", br)
                    }
                    else {
                        Log.d("서버 실패 응답", br)
                    }


                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
//                    물리적인 접속 오류
                }
            })

        }
    }

    fun setValues() {

    }
}