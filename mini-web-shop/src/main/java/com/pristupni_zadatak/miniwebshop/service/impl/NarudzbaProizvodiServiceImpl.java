package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;
import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import com.pristupni_zadatak.miniwebshop.repository.NarudzbaProizvodiRepository;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaProizvodiService;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NarudzbaProizvodiServiceImpl implements NarudzbaProizvodiService {

    private final NarudzbaProizvodiRepository repository;

    private final ProizvodService proizvodService;

    public NarudzbaProizvodiServiceImpl(NarudzbaProizvodiRepository repository, ProizvodService proizvodService) {
        this.repository = repository;
        this.proizvodService = proizvodService;
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
        Proizvod proizvod= proizvodService.get(narudzbaProizvodi.getProizvodId());
        proizvod.setKolicina(proizvod.getKolicina()-1);
        proizvodService.edit(proizvod.getId(), proizvod);
        repository.save(narudzbaProizvodi);
    }

    @Override
    public void edit(Long id, NarudzbaProizvodi narudzbaProizvodi) {
        narudzbaProizvodi.setId(id);
        repository.save(narudzbaProizvodi);
    }

    @Override
    public void delete(Long id) {
        Proizvod proizvod= proizvodService.get(repository.getById(id).getProizvodId());
        proizvod.setKolicina(proizvod.getKolicina()+1);
        proizvodService.edit(proizvod.getId(), proizvod);
        repository.delete(repository.getById(id));
    }
}
