package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.entity.Narudzba;

import java.util.Arrays;
import java.util.List;

public interface NarudzbaService {
    boolean existsById(Long id);

    List<Narudzba> getAll();

    Narudzba get(Long id);

    void create(Narudzba narudzba);

    void edit(Long id, Narudzba narudzba);

    void delete(Long id);
}
