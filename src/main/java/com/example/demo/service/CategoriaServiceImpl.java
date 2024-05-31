package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Categoria;
import com.example.demo.Repositories.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Page<Categoria> getCategorias(PageRequest pageable) {
        return (Page<Categoria>) categoriaRepository.findAll(pageable);
    }

}
