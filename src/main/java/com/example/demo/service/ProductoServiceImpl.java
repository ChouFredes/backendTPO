package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Producto;
import com.example.demo.Repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Page<Producto> getProductos(PageRequest pageable) {
        return (Page<Producto>) productoRepository.findAll(pageable);
    }

}
