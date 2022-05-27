package com.neppplus.a20220526_dailyreport_retrofit

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.a20220526_dailyreport_retrofit.api.APIList
import com.neppplus.a20220526_dailyreport_retrofit.api.ServerAPI
import com.neppplus.a20220526_dailyreport_retrofit.databinding.CustomActionBarBinding
import org.w3c.dom.Text

abstract class BaseActivity :AppCompatActivity() {

    lateinit var mContext : Context
    lateinit var customBinding : CustomActionBarBinding

//    모든 화면에서 apiList 변수가 있다면 => apiList.서버기능() 형태로 간단하게 코딩 가능
    lateinit var apiList : APIList

    val TAG = javaClass.simpleName

    lateinit var closerBtn : ImageView
    lateinit var titleTxt : TextView
    lateinit var vertBtn : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this

        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
        supportActionBar?.let{
            setCustomActionBar()
        }
    }

    abstract fun setupEvents()

    abstract fun setValues()

    fun setCustomActionBar() {
        val defaultActionBar = supportActionBar!!
        defaultActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        defaultActionBar.setCustomView(R.layout.custom_action_bar)
        val myToolBar = defaultActionBar.customView.parent as androidx.appcompat.widget.Toolbar
        myToolBar.setContentInsetsAbsolute(0,0)
    }
}