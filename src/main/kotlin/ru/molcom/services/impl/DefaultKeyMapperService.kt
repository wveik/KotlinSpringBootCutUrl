package ru.molcom.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.molcom.repositories.LinkRepository
import ru.molcom.services.KeyConverterService
import ru.molcom.services.KeyMapperService
import ru.molcom.model.Link as Link

@Component
class DefaultKeyMapperService : KeyMapperService {

    @Autowired
    lateinit var converter: KeyConverterService

    @Autowired
    lateinit var repository: LinkRepository

    @Transactional
    override fun add(link: String): String {
        val newLink = Link(0, link)
        var dbLink = repository.save(newLink)

        return converter.idToKey(dbLink.id)
    }

    override fun getLink(key: String): KeyMapperService.Get {
        val id = converter.keyToId(key)
        val result = repository.findById(id)
        return if (result.isPresent) {
            KeyMapperService.Get.Link(result.get().text)
        } else {
            KeyMapperService.Get.NotFound(key)
        }
    }
}