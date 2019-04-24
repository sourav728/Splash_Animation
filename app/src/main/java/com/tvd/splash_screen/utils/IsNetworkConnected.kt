package com.tvd.splash_screen.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class NetWorkConection {
    //adding companion to the object declaration that allows an object to act similar like an static in other language
    companion object {
        @SuppressLint("MissingPermission")
        fun isNEtworkConnected(context: Context): Boolean {
            var connectionmanager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectionmanager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }
    }

}