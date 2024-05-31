package com.example.demo.Request;

import lombok.Data;
import java.util.Date;

@Data
public class ShopOrderRequest {
    private Long userID;
    private Date date;
    private Long orderTotal;
}
