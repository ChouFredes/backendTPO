package com.example.demo.service;

import com.example.demo.Entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductoService {

    Page<Producto> getProductos(PageRequest pageable);

}
