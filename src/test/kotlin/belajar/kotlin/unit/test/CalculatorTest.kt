package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.generator.SimpleDisplaynameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException


@DisplayNameGeneration(SimpleDisplaynameGenerator::class)
//@DisplayName("Test for Calculator Class")
class CalculatorTest {
    companion object{
        @BeforeAll()
        @JvmStatic
        fun beforeAll(){
            println("Mulai")

        }

        @AfterAll()
        @JvmStatic
        fun afterAll(){

            println("Selesai")
        }

    }

    val calculator = Calculator()



    @BeforeEach()
    fun beforeEach(){
        println("Sebelum Unit Test")

    }

    @AfterEach()
    fun afterEach(){

        println("Setelah Unit Test")
    }


    @Test
    //@DisplayName("Test for calculator.add(10,10)")
    fun testAddSuccess(){
        val result = calculator.add(10, 10)

        assertEquals(20, result, "Hasil salah")


    }
    @Test
    fun testAddSuccess2(){
        val result = calculator.add(20, 20)
        assertEquals(40, result, "Hasil salah")

    }

    @Test
    fun testDivideSuccess(){
        val result = calculator.divide(100, 20)
        assertEquals(5, result, "Hasil salah")

    }
    @Test
    fun testDivideFailed(){
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }

    }
    @Test
    @Disabled
    fun testComingSoon(){


    }


    @Test
    fun testAborted(){
        val profile = System.getenv()["PROFILE"]
        if ("DEV" != profile){
            throw TestAbortedException()

        }
        println("Test Not Aborted")
    }


    @Test
    fun testAssumption(){
        assumeTrue("DEV" == System.getenv()["PROFILE"])

        println("Test Not Aborted")
    }


}