package com.maycc.numeros.utilities

fun bubbleSort(numbers: ArrayList<Int>) : ArrayList<Int>{
    var aux = 0
    var limit = numbers.size - 1

    for (i in 0 until limit ) {
        for (j in 0 until limit ) {
            if (numbers[j] > numbers[j+1]){
                aux = numbers[j+1]

                numbers[j+1] = numbers[j]
                numbers[j] = aux
            }
        }
    }

    return numbers
}