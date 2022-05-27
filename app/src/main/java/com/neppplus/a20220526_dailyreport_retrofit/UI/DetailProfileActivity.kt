package com.neppplus.a20220526_dailyreport_retrofit.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.neppplus.a20220526_dailyreport_retrofit.BaseActivity
import com.neppplus.a20220526_dailyreport_retrofit.Diaglog.AlertDiaglog
import com.neppplus.a20220526_dailyreport_retrofit.R
import com.neppplus.a20220526_dailyreport_retrofit.Utils.ContextUtil
import com.neppplus.a20220526_dailyreport_retrofit.Utils.GlobalData
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityDetailProfileBinding
import com.neppplus.a20220526_dailyreport_retrofit.databinding.CustomAlertDiaglogBinding
import com.neppplus.a20220526_dailyreport_retrofit.models.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailProfileActivity : BaseActivity() {

    lateinit var binding: ActivityDetailProfileBinding
    var loginUser = GlobalData.loginUser!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.logoutBtn.setOnClickListener {
            ContextUtil.clear(mContext)
            val myIntent = Intent(mContext, LoginActivity::class.java)
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                 //       ㄴ 해당 액티비티와 관련된 TASK 전부 Clear
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                     // ㄴ Clear TASK와 함께 사용
            startActivity(myIntent)
        }

        binding.nickChangTxt.setOnClickListener {

            val alert = AlertDiaglog(mContext, this)
            alert.myDialog(
                "닉네임 변경",
                "변경할 닉네임 입력",
                false,
                object : AlertDiaglog.ButtonClickListener {
                    override fun positiveBtnClick() {
                        val changedNick = alert.binding.contentEdt.text.toString()
                        if (changedNick.isBlank()) {
                            Toast.makeText(mContext, "닉네임 공백 ㄴㄴ", Toast.LENGTH_SHORT).show()
                        } else {
                            apiList.patchRequestEditUser(
                                ContextUtil.getLoginUserToken(mContext),
                                null,
                                null,
                                null
                            ).enqueue(object : Callback<BasicResponse> {
                                override fun onResponse(
                                    call: Call<BasicResponse>,
                                    response: Response<BasicResponse>
                                ) {
                                    if (response.isSuccessful) {
                                        val br = response.body()!!
                                        GlobalData.loginUser = br.data.user
                                        binding.nicknameTxt.text = br.data.user.nick_name

                                        Toast.makeText(mContext, "닉변경 성공", Toast.LENGTH_SHORT)
                                            .show()
                                        alert.dialog.dismiss()

                                    } else {
                                        val jsonObj = JSONObject(response.errorBody()!!.string())
                                        val code = jsonObj.getInt("code")
                                        val message = jsonObj.getString("message")
                                        if (code == 400) {
                                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT)
                                                .show()
                                        } else {
                                            Log.e("${TAG}_회원정보 수정 에러", message)
                                        }

                                    }
                                }

                                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                                }

                            })
                        }
                    }

                    override fun negativeBtnClick() {
                    }

                })


        }

    }

    override fun setValues() {
        Glide.with(mContext)
            .load(loginUser.profile_img)
            .into(binding.profileImg)

        binding.emailTxt.text = loginUser.email
        binding.nicknameTxt.text = loginUser.nick_name
    }

}







