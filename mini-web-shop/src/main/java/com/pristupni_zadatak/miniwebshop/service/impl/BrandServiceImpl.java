package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.Brand;
import com.pristupni_zadatak.miniwebshop.repository.BrandRepository;
import com.pristupni_zadatak.miniwebshop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByNaziv(String naziv) {
        return repository.existsByNaziv(naziv);
    }

    @Override
    public boolean existsByNazivAndIdNot(String naziv, Long id) {
        return repository.existsByNazivAndIdNot(naziv, id);
    }

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public Brand get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji Brand koji ima id: "+id));
    }

    @Override
    public void create(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void edit(Long id, Brand brand) {
        brand.setId(id);
        repository.save(brand);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }
}
