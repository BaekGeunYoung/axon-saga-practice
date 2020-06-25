package com.geunyoung.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier


class CreateShippingCommand(@TargetAggregateIdentifier val shippingId: String, val orderId: String, val paymentId: String)