package com.neppplus.a20220526_dailyreport_retrofit.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.neppplus.a20220526_dailyreport_retrofit.api.APIList
import com.neppplus.a20220526_dailyreport_retrofit.api.ServerAPI

abstract class BaseFragment : Fragment() {

    lateinit var mContext : Context
    lateinit var apiList : APIList

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    abstract fun setupEvents()

    abstract fun setValues()

}