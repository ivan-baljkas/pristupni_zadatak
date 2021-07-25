package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.Narudzba;
import com.pristupni_zadatak.miniwebshop.repository.NarudzbaRepository;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NarudzbaServiceImpl implements NarudzbaService {

    private final NarudzbaRepository repository;

    public NarudzbaServiceImpl(NarudzbaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Narudzba> getAll() {
        return repository.findAll();
    }

    @Override
    public Narudzba get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji Narudzba koja ima id: "+id));
    }

    @Override
    public void create(Narudzba narudzba) {
        repository.save(narudzba);
    }

    @Override
    public void edit(Long id, Narudzba narudzba) {
        narudzba.setId(id);
        repository.save(narudzba);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }
}
