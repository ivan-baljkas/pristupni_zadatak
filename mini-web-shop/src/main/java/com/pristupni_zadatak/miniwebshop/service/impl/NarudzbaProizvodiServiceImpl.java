package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;
import com.pristupni_zadatak.miniwebshop.repository.NarudzbaProizvodiRepository;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaProizvodiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NarudzbaProizvodiServiceImpl implements NarudzbaProizvodiService {

    private final NarudzbaProizvodiRepository repository;

    public NarudzbaProizvodiServiceImpl(NarudzbaProizvodiRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(Long proizvodId) {
        return repository.existsById(proizvodId);
    }

    @Override
    public List<NarudzbaProizvodi> getAll() {
        return repository.findAll();
    }

    @Override
    public NarudzbaProizvodi get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji Entitet koji ima id: "+id));
    }

    @Override
    public void create(NarudzbaProizvodi narudzbaProizvodi) {
        repository.save(narudzbaProizvodi);
    }

    @Override
    public void edit(Long id, NarudzbaProizvodi narudzbaProizvodi) {
        narudzbaProizvodi.setId(id);
        repository.save(narudzbaProizvodi);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }
}
