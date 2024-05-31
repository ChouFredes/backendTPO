package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Entity
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Date date;

    @Column
    private Long orderTotal;

    public ShopOrder(Long userId, Date date, Long orderTotal) {
        this.userId=userId;
        this.date=date;
        this.orderTotal=orderTotal;

    }
    public ShopOrder(){

    }
}
