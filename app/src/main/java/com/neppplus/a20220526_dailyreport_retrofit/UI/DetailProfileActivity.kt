package com.neppplus.a20220526_dailyreport_retrofit.UI

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.neppplus.a20220526_dailyreport_retrofit.BaseActivity
import com.neppplus.a20220526_dailyreport_retrofit.R
import com.neppplus.a20220526_dailyreport_retrofit.Utils.ContextUtil
import com.neppplus.a20220526_dailyreport_retrofit.Utils.GlobalData
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityDetailProfileBinding

class DetailProfileActivity : BaseActivity() {

    lateinit var binding : ActivityDetailProfileBinding
    var loginUser = GlobalData.loginUser!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.logoutBtn.setOnClickListener {
            ContextUtil.clear(mContext)
            val myItent = Intent(mContext,LoginActivity::class.java)
            myItent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(myItent)
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