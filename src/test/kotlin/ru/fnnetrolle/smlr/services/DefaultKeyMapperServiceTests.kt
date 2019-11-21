package ru.fnnetrolle.smlr.services

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ru.fnnetrolle.smlr.services.Impl.DefaultKeyMapperService

class DefaultKeyMapperServiceTests {

    @InjectMocks
    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "aaAAbbBB"

    private val KEY_A: String = "abc"
    private val KEY_B: String = "cde"

    private val ID_A: Long = 3000000L
    private val ID_B: Long = 3000001L


    @Mock
    lateinit var converter: KeyConverterService

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(converter.keyToId(KEY_A)).thenReturn(ID_A)
        Mockito.`when`(converter.idToKey(ID_A)).thenReturn(KEY_A)
    }

    @Test
    fun clientCanAddLinks() {

        val keyA = service.add(KEY_A)
        var linkA = service.getLink(keyA)
        Assert.assertEquals(KeyMapperService.Get.Link(KEY_A), linkA)

    }


    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        Assert.assertEquals(KeyMapperService.Get.NotFound(KEY),
                service.getLink(KEY))
    }

}