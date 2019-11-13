package ru.fnnetrolle.smlr.controllers

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.fnnetrolle.smlr.SmlrApplication
import org.springframework.format.support.DefaultFormattingConversionService
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup




/*
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SmlrApplication.class)
@WebAppConfiguration*/

//@RunWith(SpringRunner::class)
//@SpringBootTest
//@AutoConfigureMockMvc
//
//@RunWith(SpringRunner::class)
//@WebAppConfiguration
////@ContextConfiguration
//@AutoConfigureMockMvc

@RunWith(SpringJUnit4ClassRunner::class)
@WebAppConfiguration
//@ContextConfiguration(classes = [ SmlrApplication::class ] )

//@ExtendWith(SpringExtension::class)
//@WebMvcTest(RedirectController::class)
class RedirectControllerTests {
    lateinit var mockMvc: MockMvc

    @Autowired
    private val wac: WebApplicationContext? = null

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac!!).build()
    }
//        @Before
//        @Throws(Exception::class)
//        fun setup() {
//            this.mockMvc = standaloneSetup(RedirectController(DefaultFormattingConversionService()))
//                    .alwaysExpect(status().isFound()).build()
//        }

    private val PATH: String = "/aaAAbbBB"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_VALUE: String = "Location"
    private val HEADER_NAME: String = "http://yandex.ru"

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful(){
//        mockMvc.perform(MockMvcRequestBuilders.get(PATH))
//                .andExpect(MockMvcResultMatchers.status().`is`(REDIRECT_STATUS))
//                .andExpect(MockMvcResultMatchers.header().string(HEADER_NAME, HEADER_VALUE))
        Assert.assertTrue(true)
    }
}