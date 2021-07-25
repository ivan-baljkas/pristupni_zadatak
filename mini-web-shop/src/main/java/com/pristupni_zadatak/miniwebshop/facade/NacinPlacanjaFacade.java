package com.pristupni_zadatak.miniwebshop.facade;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;

import java.util.List;

public interface NacinPlacanjaFacade {

    List<NacinPlacanjaDto> getAll();

    NacinPlacanjaDto get(Long id);
}
