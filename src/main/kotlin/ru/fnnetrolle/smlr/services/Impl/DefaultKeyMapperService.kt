package ru.fnnetrolle.smlr.services.Impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.fnnetrolle.smlr.services.KeyConverterService
import ru.fnnetrolle.smlr.services.KeyMapperService
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

@Component
class DefaultKeyMapperService : KeyMapperService {

    @Autowired
    lateinit var converter: KeyConverterService

    val sequence = AtomicLong(3000000L)

    private val map: MutableMap<Long, String> = ConcurrentHashMap()

    override fun add(key: String): String {
        val id = sequence.get()
        val key = converter.idToKey(id)
        map[id] = key

        return key
    }

    override fun getLink(key: String): KeyMapperService.Get {
        val id = converter.keyToId(key)
        val result = map[id]

        if (result == null)
            return KeyMapperService.Get.NotFound(key)

        return KeyMapperService.Get.Link(result)

    }
}