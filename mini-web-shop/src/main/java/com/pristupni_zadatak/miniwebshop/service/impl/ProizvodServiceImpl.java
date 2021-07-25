package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import com.pristupni_zadatak.miniwebshop.repository.ProizvodRepository;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements ProizvodService {

    private final ProizvodRepository repository;

    public ProizvodServiceImpl(ProizvodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Proizvod> getAll() {
        return repository.findAll();
    }

    @Override
    public Proizvod get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji Proizvod koji ima id: "+id));
    }

    @Override
    public void create(Proizvod proizvod) {
        repository.save(proizvod);
    }

    @Override
    public void edit(Long id, Proizvod proizvod) {
        proizvod.setId(id);
        repository.save(proizvod);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
