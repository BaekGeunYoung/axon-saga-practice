package com.geunyoung.shippingservice.domain

import com.geunyoung.coreapi.command.CreateShippingCommand
import com.geunyoung.coreapi.event.OrderShippedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class ShippingAggregate {
    @AggregateIdentifier
    private lateinit var shippingId: String
    private lateinit var orderId: String
    private lateinit var paymentId: String

    constructor()

    @CommandHandler
    constructor(createShippingCommand: CreateShippingCommand) {
        shippingId = createShippingCommand.shippingId
        AggregateLifecycle.apply(
                OrderShippedEvent(
                        createShippingCommand.shippingId,
                        createShippingCommand.orderId,
                        createShippingCommand.paymentId
                )
        )
    }

    @EventSourcingHandler
    fun on(orderShippedEvent: OrderShippedEvent) {
        orderId = orderShippedEvent.orderId
        paymentId = orderShippedEvent.paymentId
    }
}