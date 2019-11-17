package ru.fnnetrolle.smlr.services

interface KeyMapperService {
    interface Add {
        data class Success(val Key: String, val Link: String): Add

        data class AlreadyExist(val key: String): Add
    }

    interface Get {
        data class Link(val link: String): Get

        data class NotFound(val key: String): Get
    }

    fun add(key: String, link: String): Add

    fun getLink(key: String): Get
}