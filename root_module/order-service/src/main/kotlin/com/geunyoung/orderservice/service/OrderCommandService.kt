package com.geunyoung.orderservice.service

import com.geunyoung.orderservice.dto.OrderCreateDto
import java.util.concurrent.CompletableFuture

interface OrderCommandService {
    fun createOrder(orderCreateDto: OrderCreateDto): CompletableFuture<String>
}