package com.geunyoung.paymentservice.domain

import com.geunyoung.coreapi.command.CreateInvoiceCommand
import com.geunyoung.coreapi.event.InvoiceCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class InvoiceAggregate {
    @AggregateIdentifier
    private lateinit var paymentId: String
    private lateinit var orderId: String
    private lateinit var invoiceStatus: String

    constructor()

    @CommandHandler
    constructor(createInvoiceCommand: CreateInvoiceCommand) {
        paymentId = createInvoiceCommand.paymentId
        AggregateLifecycle.apply(
                InvoiceCreatedEvent(
                        createInvoiceCommand.paymentId,
                        createInvoiceCommand.orderId
                )
        )
    }

    @EventSourcingHandler
    fun on(invoiceCreatedEvent: InvoiceCreatedEvent) {
        orderId = invoiceCreatedEvent.orderId
        invoiceStatus = "PAID"
    }
}