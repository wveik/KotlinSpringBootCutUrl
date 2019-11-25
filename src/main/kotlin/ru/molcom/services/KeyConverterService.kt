package ru.molcom.services

interface KeyConverterService {
    fun keyToId(key: String): Long

    fun idToKey(id: Long): String
}