package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class TestMock {

    @Test
    fun testMock() {

        val list: List<String> = Mockito.mock(List::class.java) as List<String>
        Mockito.`when`(list[0]).thenReturn("Eggy")
        Mockito.`when`(list[1]).thenReturn("Andika")

        assertEquals("Eggy", list[0])
        assertEquals("Eggy", list[0])

        assertEquals("Andika", list[1])


        Mockito.verify(list, Mockito.times(2))[0]
        Mockito.verify(list)[1]



    }
}