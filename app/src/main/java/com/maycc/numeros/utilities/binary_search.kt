package com.maycc.numeros.utilities

fun binarySearch(numbers :ArrayList<Int>, searchedNumber :Int) :Int {
    var lower = 0
    var higher = numbers.size - 1
    var middle = 0

    while (lower <= higher) {
        middle = (lower + higher) / 2

        if (searchedNumber == numbers[middle]) {
            return middle
        }

        if (searchedNumber > numbers[middle]) {
            lower = middle + 1
        } else{
            higher = middle - 1
        }
    }

    return -1
}