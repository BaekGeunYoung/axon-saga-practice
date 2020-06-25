package com.geunyoung.paymentservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(PaymentServiceApplication::class.java, *args)
}
