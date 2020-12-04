package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*

class ConditionalTest {




    @Test
    @EnabledOnOs(value = [OS.WINDOWS])
    fun runOnWindows(){
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun notRunOnWindows(){
    }


    @Test
    @EnabledOnJre(value = [JRE.JAVA_14])
    fun runOnJavaJre(){
    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_14])
    fun notRunOnJavaJre(){
    }


    @Test
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun enableOnOracle(){
    }

    @Test
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnOracle(){
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun enabledOnDev(){
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun disabledOnDev(){
    }







    @Test
    fun printSystemProperties(){
        System.getProperties().forEach { key, value ->
            println("$key => $value")
        }
    }






}