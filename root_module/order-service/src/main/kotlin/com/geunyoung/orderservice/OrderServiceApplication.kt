package com.geunyoung.orderservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(OrderServiceApplication::class.java, *args)
}
