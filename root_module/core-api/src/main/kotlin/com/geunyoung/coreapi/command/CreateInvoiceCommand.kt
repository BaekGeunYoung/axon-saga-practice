package com.geunyoung.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier


class CreateInvoiceCommand(@TargetAggregateIdentifier val paymentId: String, val orderId: String)