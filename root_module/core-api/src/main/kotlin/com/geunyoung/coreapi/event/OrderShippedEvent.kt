package com.geunyoung.coreapi.event

class OrderShippedEvent(val shippingId: String, val orderId: String, val paymentId: String)