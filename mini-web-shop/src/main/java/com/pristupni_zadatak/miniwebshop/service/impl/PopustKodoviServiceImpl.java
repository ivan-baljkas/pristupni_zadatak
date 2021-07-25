package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.repository.PopustKodoviRepository;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import org.springframework.stereotype.Service;

@Service
public class PopustKodoviServiceImpl implements PopustKodoviService {

    private final PopustKodoviRepository repository;

    public PopustKodoviServiceImpl(PopustKodoviRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
