package com.example.currencyapp

import android.content.Context
import android.net.ConnectivityManager

class Utils {
    companion object {

        val SOAP_URL = "http://nbg.gov.ge/currency_service.php"
        val SOAP_NAMESPACE = "urn:NBGCurrency"
        val METHOD_GetCurrency = "GetCurrency"


        fun isConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}