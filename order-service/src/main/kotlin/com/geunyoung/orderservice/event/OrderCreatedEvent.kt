package com.geunyoung.orderservice.event

import java.math.BigDecimal


class OrderCreatedEvent(val orderId: String, val itemType: String, val price: BigDecimal, val currency: String, val orderStatus: String)