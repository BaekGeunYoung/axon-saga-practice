package com.geunyoung.orderservice.event

class OrderUpdatedEvent(val orderId: String, val orderStatus: String)