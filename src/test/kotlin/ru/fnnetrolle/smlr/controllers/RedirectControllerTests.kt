package ru.fnnetrolle.smlr.controllers

import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest
@AutoConfigureMockMvc
class RedirectControllerTests {
    @Autowired
    private var mockMvc: MockMvc? = null

    private val PATH: String = "/aaAAbbBB"
    private val REDIRECT_STATUS: Int = 302

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(RedirectController())
                .build()
    }

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        mockMvc!!.perform(MockMvcRequestBuilders.get(PATH))
                .andExpect(MockMvcResultMatchers.status().`is`(REDIRECT_STATUS))
    }

    private val BAD_PATH: String = "/Ollo"
    private val NOT_FOUND: Int = 404

    @Test
    fun controllerMustReturn404IfBadKey() {
        mockMvc!!.perform(MockMvcRequestBuilders.get(BAD_PATH))
                .andExpect(MockMvcResultMatchers.status().`is`(NOT_FOUND))
    }
}