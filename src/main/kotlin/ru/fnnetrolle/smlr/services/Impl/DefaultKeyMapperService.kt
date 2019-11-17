package ru.fnnetrolle.smlr.services.Impl

import org.springframework.stereotype.Component
import ru.fnnetrolle.smlr.services.KeyMapperService
import java.util.concurrent.ConcurrentHashMap

@Component
class DefaultKeyMapperService : KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()

    override fun add(key: String, link: String): KeyMapperService.Add {
        if (map.containsKey(key))
            return KeyMapperService.Add.AlreadyExist(key)

        map[key] = link
        return KeyMapperService.Add.Success(key, link)
    }

    override fun getLink(key: String): KeyMapperService.Get {
        if (map.containsKey(key))
            return KeyMapperService.Get.Link(map[key]!!)

        return KeyMapperService.Get.NotFound(key)
    }
}