package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import com.pristupni_zadatak.miniwebshop.repository.PopustKodoviRepository;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public List<PopustKodovi> getAll(Boolean iskoristen) {
        if(iskoristen == null){
            return repository.findAll();
        }
        else{
            return repository.findAllByIskoristen(iskoristen);
        }
    }

    @Override
    public PopustKodovi get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji PopustKod koji ima id: "+id));
    }

    @Override
    public void create(PopustKodovi popustKodovi) {
        repository.save(popustKodovi);
    }

    @Override
    public void edit(Long id, PopustKodovi popustKodovi) {
        popustKodovi.setId(id);
        repository.save(popustKodovi);
    }

    @Override
    public PopustKodovi getByKod(String kod) {
        return repository.findFirstByKod(kod)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji PopustKod koji ima kod: "+kod));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }
}
