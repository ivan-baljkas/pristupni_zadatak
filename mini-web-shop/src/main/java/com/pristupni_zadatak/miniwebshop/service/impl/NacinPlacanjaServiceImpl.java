package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;
import com.pristupni_zadatak.miniwebshop.repository.NacinPlacanjaRepository;
import com.pristupni_zadatak.miniwebshop.service.NacinPlacanjaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NacinPlacanjaServiceImpl implements NacinPlacanjaService {

    private final NacinPlacanjaRepository repository;

    public NacinPlacanjaServiceImpl(NacinPlacanjaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NacinPlacanja> getAll() {
        return repository.findAll();
    }

    @Override
    public NacinPlacanja get(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new NullPointerException("Ne postoji način plaćanja koji ima ovaj id: "+id));
    }
}
