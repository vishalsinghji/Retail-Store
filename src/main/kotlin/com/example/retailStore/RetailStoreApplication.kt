package com.example.retailStore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RetailStoreApplication

fun main(args: Array<String>) {
	println("Hello")
	runApplication<RetailStoreApplication>(*args)
}
