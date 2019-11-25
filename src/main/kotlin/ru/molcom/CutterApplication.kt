package ru.molcom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CutterApplication

fun main(args: Array<String>) {
    runApplication<CutterApplication>(*args)
}
