package com.assignment.myresume.utils

import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkUtils @Inject constructor(
    private val connectivityManager: ConnectivityManager
) {
    fun isNetworkAvailable(): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                return true
            }
        } else {
            return false
        }
        return false
    }
}
