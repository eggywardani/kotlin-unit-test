package belajar.kotlin.unit.test.service

import belajar.kotlin.unit.test.model.Person
import belajar.kotlin.unit.test.repository.PersonRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.lang.Exception
import java.lang.IllegalArgumentException


@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest{

    @Mock
    lateinit var personRepository: PersonRepository


    lateinit var personService: PersonService


    @BeforeEach
    fun setUp(){
        personService = PersonService(personRepository)

    }

    @Test
    fun testPersonIdIsNotValid(){
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            personService.get("     ")
        }

    }

    @Test
    fun testPersonNotFound(){
        org.junit.jupiter.api.assertThrows<Exception> {
            personService.get("not found")
        }

    }
    @Test
    fun testPersonSuccess (){

        Mockito.`when`(personRepository.selectById("eggy")).thenReturn(Person("eggy", "Eggy Andika Wardani"))
        val person = personService.get("eggy")

        assertEquals("eggy", person.id)
        assertEquals("Eggy Andika Wardani", person.name)

    }

    @Test
    fun testRegisterPersonNameIsBlank(){
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {

            personService.register("  ")
        }

    }
    @Test
    fun testRegisterSuccess(){
        val person = personService.register("Eggy")
        assertEquals("Eggy", person.name)
        assertNotNull(person.id)


        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, "Eggy"))

    }



}