package com.maycc.numeros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.maycc.numeros.utilities.alertDialogAskNumber
import com.maycc.numeros.utilities.binarySearch
import com.maycc.numeros.utilities.bubbleSort
import com.maycc.numeros.utilities.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var arrayListNumbers = arrayListOf<Int>()
    private var adapter :ArrayAdapter<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initListViewNumbers()
        addListenerBtnEnter()
        addListenerBtnSort()
        addListenerBtnSearch()
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
                addNumberToArrayListNumbers(number.toInt())
            } else {
                showToast(this, "Por favor ingresa un número")
            }

        }
    }
    private fun isEnterNumber (number :String) = number.isNotEmpty()

    private fun addNumberToArrayListNumbers(number: Int) {
        arrayListNumbers.add(number)
        adapter?.notifyDataSetChanged()
    }

    private fun addListenerBtnSort() {
        btnSort.setOnClickListener {
            if (arrayListNumbers.isNotEmpty()) {
                updateArrayNumbers()
                showToast(this, "Números ordenados!!!")
            }else {
                showToast(this, "Nada que ordenar!!!")
            }
        }
    }

    private fun updateArrayNumbers() {
        val orderedNumbers = bubbleSort(arrayListNumbers)
        arrayListNumbers = orderedNumbers
        adapter?.notifyDataSetChanged()
    }

    private fun addListenerBtnSearch() {
        btnSearch.setOnClickListener {
            if (arrayListNumbers.isNotEmpty()) {
                updateArrayNumbers()
                alertDialogAskNumber(this, arrayListNumbers)
            }else {
                showToast(this, "Nada que Buscar!!!")
            }
        }
    }
}
