package com.neppplus.a20220526_dailyreport_retrofit.Utils

import android.content.Context
import android.media.session.MediaSession

class ContextUtil {

    companion object {

        private val prefName = "DailyReport"
        private val AUTO_LOGIN = "AUTO_LOGIN"
        private val LOGIN_USER_TOKEN = "LOGIN_USER_TOKEN"

        fun setAutoLogin(context: Context, isAutoLogin : Boolean ) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(AUTO_LOGIN,isAutoLogin).apply()
                                         //     ㄴ 기본값 false 를 넣게되면 항상 false 값만 나옴

        }


        fun getAutoLogin ( context: Context ) : Boolean {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(AUTO_LOGIN,false)
                                        //          ㄴ 딱히 다른 값이 없으면 기본값을 불러온다
                                         //        null point Exception 방지용
        }

        fun setLoginUserToken(context: Context, token : String ) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(LOGIN_USER_TOKEN,token).apply()
        }

        fun getLoginUserToken ( context: Context) : String {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getString(LOGIN_USER_TOKEN,"")!!
                                                         //   ㄴ Null값이 있지 않다

        }

    }
}