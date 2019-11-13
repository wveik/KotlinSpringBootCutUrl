package ru.fnnetrolle.smlr.controllers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


/*
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SmlrApplication.class)
@WebAppConfiguration*/
@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class RedirectController {
    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(webApplicationContext).build()
    }

    private val PATH: String = "/aaAAbbBB"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_VALUE: String = "Location"
    private val HEADER_NAME: String = "http://yandex.ru"

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful(){
        mockMvc.perform(MockMvcRequestBuilders.get(PATH))
                .andExpect(MockMvcResultMatchers.status().`is`(REDIRECT_STATUS))
                .andExpect(MockMvcResultMatchers.header().string(HEADER_NAME, HEADER_VALUE))
    }
}