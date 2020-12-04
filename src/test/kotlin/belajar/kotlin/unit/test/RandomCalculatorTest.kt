package belajar.kotlin.unit.test


import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*


class RandomCalculatorTest: ParentCalculatorTest(){


    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value:Int){
        assertEquals(value + value, calculator.add(value, value))
    }
    companion object{

        @JvmStatic
        fun parameterSource():List<Int>{
            return listOf(1,2,3,4,5)
        }
    }
    @DisplayName("Test Calculator Random")
    @RepeatedTest(
            value = 10,
            name =  "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandom(random: Random, testInfo: TestInfo, repetitionInfo: RepetitionInfo) {


        println("""
            ${testInfo.displayName}
            ${repetitionInfo.currentRepetition}
            ${repetitionInfo.totalRepetitions}
        """.trimIndent())
        val first = random.nextInt(1000)
        println(first)
        val second = random.nextInt(1000)
        println(second)

        val result = calculator.add(first, second)

        assertEquals(first + second, result)

    }

    @DisplayName("Test Calculator with Parameter")
    @ParameterizedTest(
            name = "{displayName} with data {0}"
    )
    @ValueSource(ints = [1,2,3,4,5])
    fun testWithParameter(value:Int){
        val result = calculator.add(value, value)
        println(result)
        assertEquals(value + value, result)

    }
}