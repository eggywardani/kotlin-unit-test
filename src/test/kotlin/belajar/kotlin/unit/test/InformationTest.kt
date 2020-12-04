package belajar.kotlin.unit.test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo

@Tag("Test with TestInfo")
class InformationTest {



    @Test
    @Tag("Cool")
    @DisplayName("TEST ONE")
    fun test1(testInfo: TestInfo){
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testClass)
        println(testInfo.testMethod)


    }
}