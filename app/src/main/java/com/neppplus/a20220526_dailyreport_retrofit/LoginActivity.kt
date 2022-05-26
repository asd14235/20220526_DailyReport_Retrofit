package com.neppplus.a20220526_dailyreport_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityLoginBinding
import com.neppplus.a20220526_dailyreport_retrofit.models.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.signUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }



        binding.loginBtn.setOnClickListener {
            val editEmail = binding.emailEdt.text.toString()
            val editPw = binding.passwordEdt.text.toString()

            apiList.postRequestLogin(editEmail, editPw).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("서버 성공", response.body()!!.toString())

                    }

                    else {
                        Log.d("서버 실패", response.errorBody().toString())

                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })

        }
    }

    override fun setValues() {

    }
}