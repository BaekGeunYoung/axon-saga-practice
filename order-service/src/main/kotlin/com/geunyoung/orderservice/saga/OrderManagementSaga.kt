package com.geunyoung.orderservice.saga

import com.geunyoung.orderservice.command.CreateInvoiceCommand
import com.geunyoung.orderservice.command.CreateShippingCommand
import com.geunyoung.orderservice.command.UpdateOrderStatusCommand
import com.geunyoung.orderservice.event.InvoiceCreatedEvent
import com.geunyoung.orderservice.event.OrderCreatedEvent
import com.geunyoung.orderservice.event.OrderShippedEvent
import com.geunyoung.orderservice.event.OrderUpdatedEvent
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.modelling.saga.SagaEventHandler
import org.axonframework.modelling.saga.SagaLifecycle
import org.axonframework.modelling.saga.StartSaga
import org.axonframework.spring.stereotype.Saga
import org.hibernate.sql.Update
import org.springframework.beans.factory.annotation.Autowired
import java.util.*


@Saga
class OrderManagementSaga(
        @Autowired
        @Transient
        private val commandGateway: CommandGateway
) {
    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderCreatedEvent: OrderCreatedEvent) {
        val paymentId = UUID.randomUUID().toString()
        println("Saga invoked")

        //associate Saga
        SagaLifecycle.associateWith("paymentId", paymentId)
        println("order id" + orderCreatedEvent.orderId)

        //send the commands
        commandGateway.send<CreateInvoiceCommand>(CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId))
    }

    @SagaEventHandler(associationProperty = "paymentId")
    fun handle(invoiceCreatedEvent: InvoiceCreatedEvent) {
        val shippingId = UUID.randomUUID().toString()
        println("Saga continued")

        //associate Saga with shipping
        SagaLifecycle.associateWith("shipping", shippingId)

        //send the create shipping command
        commandGateway.send<CreateShippingCommand>(CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId))
    }

    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderShippedEvent: OrderShippedEvent) {
        commandGateway.send<UpdateOrderStatusCommand>(UpdateOrderStatusCommand(orderShippedEvent.orderId, "SHIPPED"))
    }

    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderUpdatedEvent: OrderUpdatedEvent?) {
        SagaLifecycle.end()
    }
}
