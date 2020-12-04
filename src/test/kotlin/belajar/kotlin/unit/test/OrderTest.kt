package belajar.kotlin.unit.test

import org.junit.jupiter.api.*

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
class OrderTest {

    var counter =0

    @BeforeAll
    fun beforeAll(){

    }
    @AfterAll
    fun afterAll(){

    }

    @Test
    @Order(3)
    fun test1(){
        counter++
        println(counter)
    }

    @Test
    @Order(1)
    fun test2(){
        counter++
        println(counter)
    }

    @Test
    @Order(2)
    fun test3(){
        counter++
        println(counter)
    }


}