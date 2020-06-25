package com.geunyoung.orderservice.domain

import com.geunyoung.coreapi.command.CreateOrderCommand
import com.geunyoung.coreapi.command.UpdateOrderStatusCommand
import com.geunyoung.coreapi.event.OrderCreatedEvent
import com.geunyoung.coreapi.event.OrderUpdatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.math.BigDecimal


@Aggregate
class OrderAggregate  {
    @AggregateIdentifier
    private lateinit var orderId: String
    private lateinit var itemType: String
    private lateinit var currency: String
    private lateinit var orderStatus: String
    private lateinit var price: BigDecimal

    constructor()

    @CommandHandler
    constructor(createOrderCommand: CreateOrderCommand) {
        orderId = createOrderCommand.orderId
        AggregateLifecycle.apply(
                OrderCreatedEvent(
                        createOrderCommand.orderId,
                        createOrderCommand.itemType,
                        createOrderCommand.price,
                        createOrderCommand.currency,
                        createOrderCommand.orderStatus
                )
        )
    }

    @EventSourcingHandler
    protected fun on(orderCreatedEvent: OrderCreatedEvent) {
        orderId = orderCreatedEvent.orderId
        itemType = orderCreatedEvent.itemType
        price = orderCreatedEvent.price
        currency = orderCreatedEvent.currency
        orderStatus = orderCreatedEvent.orderStatus
    }

    @CommandHandler
    protected fun on(updateOrderStatusCommand: UpdateOrderStatusCommand) {
        AggregateLifecycle.apply(
                OrderUpdatedEvent(
                        updateOrderStatusCommand.orderId,
                        updateOrderStatusCommand.orderStatus
                )
        )
    }

    @EventSourcingHandler
    protected fun on(orderUpdatedEvent: OrderUpdatedEvent) {
        orderId = orderUpdatedEvent.orderId
        orderStatus = orderUpdatedEvent.orderStatus
    }
}