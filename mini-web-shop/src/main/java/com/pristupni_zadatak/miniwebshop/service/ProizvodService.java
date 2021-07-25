package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.entity.Proizvod;

import java.util.Arrays;
import java.util.List;

public interface ProizvodService {
    
    List<Proizvod> getAll();

    Proizvod get(Long id);

    void create(Proizvod proizvod);

    void edit(Long id, Proizvod proizvod);

    void delete(Long id);

    boolean existsById(Long id);
}
