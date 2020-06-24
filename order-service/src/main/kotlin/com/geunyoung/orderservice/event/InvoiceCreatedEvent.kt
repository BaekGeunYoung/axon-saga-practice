package com.geunyoung.orderservice.event

class InvoiceCreatedEvent(val paymentId: String, val orderId: String)