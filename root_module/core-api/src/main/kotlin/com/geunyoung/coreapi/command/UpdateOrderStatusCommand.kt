package com.geunyoung.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier


class UpdateOrderStatusCommand(@TargetAggregateIdentifier val orderId: String, val orderStatus: String)