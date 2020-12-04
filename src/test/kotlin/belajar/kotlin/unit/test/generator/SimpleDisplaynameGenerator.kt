package belajar.kotlin.unit.test.generator

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

class SimpleDisplaynameGenerator:DisplayNameGenerator {
    override fun generateDisplayNameForNestedClass(nestedClass: Class<*>?): String {
        return "Test ${nestedClass?.simpleName}"

    }

    override fun generateDisplayNameForMethod(testClass: Class<*>?, testMethod: Method?): String {
        return "Test ${testClass?.simpleName}.${testMethod?.name}"
    }

    override fun generateDisplayNameForClass(testClass: Class<*>?): String {
        return "Test ${testClass?.simpleName}"
    }
}