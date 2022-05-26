package com.neppplus.a20220526_dailyreport_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.neppplus.a20220526_dailyreport_retrofit.api.APIList
import com.neppplus.a20220526_dailyreport_retrofit.api.ServerAPI
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityLoginBinding
import com.neppplus.a20220526_dailyreport_retrofit.models.BasicResponse
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

        binding.loginBtn.setOnClickListener {
//            로그인 기능 (임시)  => BaseActivity로 옮겨서 모든화면에서
            val retrofit = ServerAPI.getRetrofit()
            val apiList = retrofit.create(APIList::class.java)

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

    fun setValues() {

    }
}