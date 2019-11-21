package ru.fnnetrolle.smlr.services

import org.junit.Assert
import org.junit.Test
import ru.fnnetrolle.smlr.services.Impl.DefaultKeyConverterService
import java.util.*

class DefaultKeyConverterServiceTest {

    private val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBotWays() {
        val random = Random()

        for (i in 0..1000L) {
            val id = Math.abs(random.nextLong())
            val key = service.idToKey(id)
            val checkId = service.keyToId(key)

            Assert.assertEquals(id, checkId)
        }

    }
}