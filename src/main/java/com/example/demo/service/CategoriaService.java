package com.example.demo.service;

import com.example.demo.Entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CategoriaService {

    Page<Categoria> getCategorias(PageRequest pageable);

}
