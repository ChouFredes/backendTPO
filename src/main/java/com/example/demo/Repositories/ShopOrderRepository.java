package com.example.demo.Repositories;

import com.example.demo.Entities.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {

}
