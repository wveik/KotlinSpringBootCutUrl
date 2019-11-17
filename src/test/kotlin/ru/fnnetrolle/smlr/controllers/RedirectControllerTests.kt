package ru.fnnetrolle.smlr.controllers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.fnnetrolle.smlr.SmlrApplication
import ru.fnnetrolle.smlr.services.KeyMapperService

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [SmlrApplication::class])
@WebAppConfiguration
class RedirectControllerTests {
    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    private var mockMvc: MockMvc? = null

    private val PATH: String = "aaAAbbBB"
    private val REDIRECT_STATUS: Int = 302

    @Mock
    lateinit var service: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: RedirectController

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build()

        Mockito.`when`(service.getLink(PATH))
                .thenReturn(KeyMapperService.Get.Link(PATH))


        Mockito.`when`(service.getLink(BAD_PATH))
                .thenReturn(KeyMapperService.Get.NotFound(BAD_PATH))
    }

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        controller.str = "dasdasds"

        mockMvc!!.perform(MockMvcRequestBuilders.get("/$PATH"))
                .andExpect(MockMvcResultMatchers.status().`is`(REDIRECT_STATUS))
    }

    private val BAD_PATH: String = "/Ollo"
    private val NOT_FOUND: Int = 404

    @Test
    fun controllerMustReturn404IfBadKey() {
        mockMvc!!.perform(MockMvcRequestBuilders.get("/$BAD_PATH"))
                .andExpect(MockMvcResultMatchers.status().`is`(NOT_FOUND))
    }
}