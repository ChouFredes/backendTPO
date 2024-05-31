package com.example.demo.Request;

import lombok.Data;

@Data
public class OrderLineRequest {
    private Long productId;
    private Long orderId;
    private Long qty;
    private Long price;
}
