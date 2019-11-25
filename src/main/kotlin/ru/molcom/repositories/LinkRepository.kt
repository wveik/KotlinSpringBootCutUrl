package ru.molcom.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.Repository
import ru.molcom.model.Link
import java.util.*

//interface LinkRepository : Repository<Link, Long> {
//
//    fun findOne(id: Long?): Optional<Link>
//
//    fun save(link: Link): Link
//
//    fun findAll(): List<Link>
//
//}
interface LinkRepository : JpaRepository<Link, Long> {



}