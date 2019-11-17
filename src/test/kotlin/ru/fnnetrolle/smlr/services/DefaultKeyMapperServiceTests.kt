package ru.fnnetrolle.smlr.services

import org.junit.Assert
import org.junit.Test
import ru.fnnetrolle.smlr.services.Impl.DefaultKeyMapperService

class DefaultKeyMapperServiceTests {

    private val KEY: String = "aaAAbbBB"
    private val LINK: String = "https://yandex.ru/"
    private val LINK_NEW: String = "https://www.google.ru/"

    private val service : KeyMapperService = DefaultKeyMapperService()

    @Test
    fun clientCanAddNewKeyWithLink() {
        Assert.assertEquals(KeyMapperService.Add.Success(KEY, LINK),
                service.add(KEY, LINK))

        Assert.assertEquals(KeyMapperService.Get.Link(LINK),
                service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)

        Assert.assertEquals(KeyMapperService.Add.AlreadyExist(KEY),
                service.add(KEY, LINK_NEW))

        Assert.assertEquals(KeyMapperService.Get.Link(LINK),
                service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        Assert.assertEquals(KeyMapperService.Get.NotFound(KEY),
                service.getLink(KEY))
    }
}