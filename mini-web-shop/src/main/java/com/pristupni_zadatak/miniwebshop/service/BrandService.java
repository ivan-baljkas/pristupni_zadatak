package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.entity.Brand;

import java.util.Arrays;
import java.util.List;

public interface BrandService {

    boolean existsById(Long id);

    boolean existsByNaziv(String naziv);

    boolean existsByNazivAndIdNot(String naziv, Long id);

    List<Brand> getAll();

    Brand get(Long id);

    void create(Brand brand);

    void edit(Long id, Brand brand);

    void delete(Long id);
}
