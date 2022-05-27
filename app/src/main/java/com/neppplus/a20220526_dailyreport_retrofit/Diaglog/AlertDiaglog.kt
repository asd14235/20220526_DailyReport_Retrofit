package com.neppplus.a20220526_dailyreport_retrofit.Diaglog

import android.app.ActionBar
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.neppplus.a20220526_dailyreport_retrofit.R
import com.neppplus.a20220526_dailyreport_retrofit.databinding.CustomAlertDiaglogBinding

class AlertDiaglog(val mContext : Context, val activity: Activity) {

    private val dialog = Dialog(mContext)

    lateinit var binding : CustomAlertDiaglogBinding

    fun myDialog ( title : String, body : String, isDelete : Boolean, onClickListener : ButtonClickListener ) {
        binding = CustomAlertDiaglogBinding.inflate(activity.layoutInflater)
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialog.setCancelable(true)

        binding.titleTxt.text = title
        binding.bodyTxt.text = body

        if (isDelete) {
            binding.positiveBtn.setBackgroundColor((ContextCompat.getColor(mContext,R.color.error_dark)))
        }

        binding.positiveBtn.setOnClickListener {
            onClickListener.positiveBtnClick()
            dialog.dismiss()
        }
        binding.negativeBtn.setOnClickListener {
            onClickListener.negativeBtnClick()
            dialog.dismiss()
        }

        dialog.show()

    }

    interface ButtonClickListener {
        fun positiveBtnClick()
        fun negativeBtnClick()
    }
}