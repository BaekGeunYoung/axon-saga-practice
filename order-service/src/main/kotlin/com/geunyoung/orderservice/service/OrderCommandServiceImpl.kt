package com.geunyoung.orderservice.service

import com.geunyoung.orderservice.command.CreateOrderCommand
import com.geunyoung.orderservice.dto.OrderCreateDto
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class OrderCommandServiceImpl(
        @Autowired private val commandGateway: CommandGateway
): OrderCommandService {
    override fun createOrder(orderCreateDto: OrderCreateDto): CompletableFuture<String> {
        return commandGateway.send(
                CreateOrderCommand(
                        UUID.randomUUID().toString(),
                        orderCreateDto.itemType,
                        orderCreateDto.price,
                        orderCreateDto.currency,
                        "CREATED"
                )
        )
    }
}