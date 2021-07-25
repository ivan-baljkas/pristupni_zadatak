package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;
import com.pristupni_zadatak.miniwebshop.facade.NacinPlacanjaFacade;
import com.pristupni_zadatak.miniwebshop.mapper.NacinPlacanjaMapper;
import com.pristupni_zadatak.miniwebshop.service.NacinPlacanjaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NacinPlacanjaFacadeImpl implements NacinPlacanjaFacade {

    private final NacinPlacanjaService service;

    private final NacinPlacanjaMapper mapper;

    public NacinPlacanjaFacadeImpl(NacinPlacanjaService service, NacinPlacanjaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public List<NacinPlacanjaDto> getAll() {
        return service.getAll()
                .stream()
                .map(nacinPlacanja ->  mapper.map(nacinPlacanja)
                ).collect(Collectors.toList());
    }

    @Override
    public NacinPlacanjaDto get(Long id) {
        return Optional.of(service.get(id))
                    .map(nacinPlacanja ->  mapper.map(nacinPlacanja)
                    ).orElse(null);
    }
}
