package com.example.demo.Repositories;

import com.example.demo.Entities.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    // Puedes agregar métodos adicionales de consulta si es necesario
}
