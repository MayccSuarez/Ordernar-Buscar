package com.maycc.numeros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var arrayListNumbers = arrayListOf<String>()
    private var adapter :ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initListViewNumbers()
        addListenerBtnEnter()
    }

    private fun initAdapter() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListNumbers)
    }

    private fun initListViewNumbers() {
        lvNumbers.adapter = adapter
    }

    private fun addListenerBtnEnter() {
        btnEnter.setOnClickListener {
            val number = edtNumber.text.toString()

            if (isEnterNumber(number)) {
                addNumberToArrayListNumbers(number)
            }

        }
    }
    private fun isEnterNumber (number :String) = number.isNotEmpty()

    private fun addNumberToArrayListNumbers(number: String) {
        arrayListNumbers.add(number)
        adapter?.notifyDataSetChanged()
    }
}
