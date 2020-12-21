package com.example.currencyapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getCitiesOfCountry().execute("USD")
        getCitiesOfCountry().execute("EUR")
        getCitiesOfCountry().execute("GBP")
        getCitiesOfCountry().execute("JPY")


    }

    inner class getCitiesOfCountry : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String {


            val response = CallWebService().callApi(Utils.METHOD_GetCurrency, params[0])
            Log.v("response", "response==" + response)
            processValue(params[0], response)

            return response
        }


    }

    fun processValue(cur: String?, value: String) {

        runOnUiThread(Runnable {
            val txt_usd_val: TextView = findViewById(R.id.txt_usd_val)
            val txt_eur_val: TextView = findViewById(R.id.txt_eur_val)
            val txt_gbp_val: TextView = findViewById(R.id.txt_gbp_val)
            val txt_jpy_val: TextView = findViewById(R.id.txt_jpy_val)

            when (cur) {
                "USD" -> txt_usd_val.setText(value)
                "EUR" -> txt_eur_val.setText(value);
                "GBP" -> txt_gbp_val.setText(value);
                "JPY" -> txt_jpy_val.setText(value);
                else -> {
                    print("currency not exits")
                }
            }
        })

    }

}

