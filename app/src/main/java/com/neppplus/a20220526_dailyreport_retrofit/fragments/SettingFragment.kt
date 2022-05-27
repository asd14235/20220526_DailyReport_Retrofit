package com.neppplus.a20220526_dailyreport_retrofit.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.neppplus.a20220526_dailyreport_retrofit.R
import com.neppplus.a20220526_dailyreport_retrofit.UI.DetailProfileActivity
import com.neppplus.a20220526_dailyreport_retrofit.Utils.GlobalData
import com.neppplus.a20220526_dailyreport_retrofit.databinding.FragmentHomeBinding
import com.neppplus.a20220526_dailyreport_retrofit.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment() {

    lateinit var binding : FragmentSettingBinding
    val loginUser = GlobalData.loginUser!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.detailProfileBtn.setOnClickListener {
            val myIntent = Intent(mContext,DetailProfileActivity::class.java)
            startActivity(myIntent)

        }
    }

    override fun setValues() {
        binding.nicknameTxt.text = loginUser.nick_name
        Glide.with(mContext)
            .load(loginUser.profile_img)
            .into(binding.profileImg)

    }
}