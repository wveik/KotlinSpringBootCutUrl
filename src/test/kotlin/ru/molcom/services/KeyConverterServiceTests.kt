package ru.molcom.services

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit4.SpringRunner
import ru.molcom.services.impl.DefaultKeyConverterService


@RunWith(SpringRunner::class)
class KeyConverterServiceTests {

    private var service: KeyConverterService? = null

    @Before
    fun init() {
        service = DefaultKeyConverterService()
    }

//    @TestConfiguration
//    internal class EmployeeServiceImplTestContextConfiguration {
//        @Bean
//        fun employeeService(): KeyConverterService {
//            return DefaultKeyConverterService()
//        }
//    }


    private val TST_ID: Long = 3000001L
    private val TST_KEY: String = "aaaA"

    @Test
    fun keyToIdTest() {
        var key = service?.idToKey(TST_ID)
        var id = key?.let { service?.keyToId(it) }

        Assert.assertEquals(id, TST_ID)
    }

    @Test
    fun idToKeyTest() {
        var id = service?.keyToId(TST_KEY)
        var key = id?.let { service?.idToKey(it) }

        Assert.assertEquals(key, TST_KEY)
    }
}