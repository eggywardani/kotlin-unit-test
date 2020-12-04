package belajar.kotlin.unit.test

import java.lang.IllegalArgumentException

class Calculator {

    fun add(first:Int, second:Int):Int{
        return first + second
    }

    fun divide(first:Int, second:Int):Int{
        if (second == 0){
            throw IllegalArgumentException("Tidak bisa dibagi nol")
        }
        return first / second
    }


}