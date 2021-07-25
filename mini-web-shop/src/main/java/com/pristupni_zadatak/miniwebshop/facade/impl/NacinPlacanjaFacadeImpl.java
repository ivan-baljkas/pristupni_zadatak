package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;
import com.pristupni_zadatak.miniwebshop.facade.NacinPlacanjaFacade;
import com.pristupni_zadatak.miniwebshop.service.NacinPlacanjaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NacinPlacanjaFacadeImpl implements NacinPlacanjaFacade {

    private final NacinPlacanjaService service;

    public NacinPlacanjaFacadeImpl(NacinPlacanjaService service) {
        this.service = service;
    }

    @Override
    public List<NacinPlacanjaDto> getAll() {
        return service.getAll()
                .stream()
                .map(nacinPlacanja -> {
                    NacinPlacanjaDto dto = new NacinPlacanjaDto();
                    dto.setNaziv(nacinPlacanja.getNaziv());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public NacinPlacanjaDto get(Long id) {
        return Optional.of(service.get(id))
                    .map(nacinPlacanja -> {
                        NacinPlacanjaDto dto = new NacinPlacanjaDto();
                        dto.setNaziv(nacinPlacanja.getNaziv());
                        return dto;
                    }).orElse(null);
    }
}
