package com.geunyoung.orderservice.controller

import com.geunyoung.orderservice.dto.OrderCreateDto
import com.geunyoung.orderservice.service.OrderCommandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/api/orders")
class OrderCommandController(
        @Autowired private val orderCommandService: OrderCommandService
) {
    @PostMapping("/")
    fun createOrder(@RequestBody orderCreateDto: OrderCreateDto): CompletableFuture<String> {
        return orderCommandService.createOrder(orderCreateDto)
    }
}