package com.maycc.numeros.utilities

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.EditText

fun alertDialogAskNumber(activity :AppCompatActivity, numbers :ArrayList<Int>)  {
    val alert = AlertDialog.Builder(activity)
    alert.setTitle("Binary Search")
    alert.setMessage("Ingresa el número a buscar: ")

    var number :Int?

    val editText = EditText(activity)
    editText.inputType = InputType.TYPE_CLASS_NUMBER
    alert.setView(editText)

    alert.setPositiveButton("BUSCAR", object: DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
            number = editText.text.toString().toInt()
            val position = binarySearch(numbers, number!!)

            if (position != -1)
                showToast(activity, "Número encontrado en la posición: $position")
            else
                showToast(activity, "Número no encontrado!!!")
        }
    })

    alert.setNegativeButton("CANCELAR", object: DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
        }
    })

    alert.show()
}