package com.neppplus.a20220526_dailyreport_retrofit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.neppplus.a20220526_dailyreport_retrofit.R
import com.neppplus.a20220526_dailyreport_retrofit.databinding.FragmentHomeBinding
import com.neppplus.a20220526_dailyreport_retrofit.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment() {

    lateinit var binding : FragmentSettingBinding

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

    }

    override fun setValues() {

    }
}