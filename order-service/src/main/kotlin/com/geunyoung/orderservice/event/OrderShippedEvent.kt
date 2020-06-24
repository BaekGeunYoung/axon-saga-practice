package com.geunyoung.orderservice.event

class OrderShippedEvent(val shippingId: String, val orderId: String, val paymentId: String)