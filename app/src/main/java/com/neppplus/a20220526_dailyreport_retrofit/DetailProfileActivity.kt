package com.neppplus.a20220526_dailyreport_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.a20220526_dailyreport_retrofit.databinding.ActivityDetailProfileBinding

class DetailProfileActivity : BaseActivity() {

    lateinit var binding : ActivityDetailProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}