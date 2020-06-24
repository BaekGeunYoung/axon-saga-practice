package com.geunyoung.orderservice.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal


class CreateOrderCommand(
        @TargetAggregateIdentifier
        val orderId: String,
        val itemType: String,
        val price: BigDecimal,
        val currency: String,
        val orderStatus: String
)