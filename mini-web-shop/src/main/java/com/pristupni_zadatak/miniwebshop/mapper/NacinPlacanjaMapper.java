package com.pristupni_zadatak.miniwebshop.mapper;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;

public interface NacinPlacanjaMapper {

    NacinPlacanjaDto map(NacinPlacanja nacinPlacanja);
}
