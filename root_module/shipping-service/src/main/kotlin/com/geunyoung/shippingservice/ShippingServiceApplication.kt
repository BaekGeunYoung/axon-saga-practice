package com.geunyoung.shippingservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShippingServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShippingServiceApplication::class.java, *args)
}
