package com.maycc.numeros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addListenerBtnEnter()
    }

    private fun addListenerBtnEnter() {
        btnEnter.setOnClickListener {
            val number = edtNumber.text.toString()

            if (isEnterNumber(number)) {
                Log.d("ENTER NUMBER", "Numero ingresado")
            }

        }
    }
    private fun isEnterNumber (number :String) = number.isNotEmpty()
}
