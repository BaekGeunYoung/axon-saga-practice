package com.geunyoung.orderservice.dto

import java.math.BigDecimal

data class OrderCreateDto(
        var itemType: String,
        var price: BigDecimal,
        var currency: String
)