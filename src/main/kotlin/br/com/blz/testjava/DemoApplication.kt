package br.com.blz.testjava

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DemoApplication

fun main(args: Array<String>) {
  runApplication<DemoApplication>(*args)
}
