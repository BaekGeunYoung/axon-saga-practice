package com.geunyoung.orderservice.command

import org.axonframework.modelling.command.TargetAggregateIdentifier


class CreateInvoiceCommand(@TargetAggregateIdentifier val paymentId: String, val orderId: String)