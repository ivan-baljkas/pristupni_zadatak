package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;
import com.pristupni_zadatak.miniwebshop.mapper.NacinPlacanjaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NacinPlacanjaMapperImpl implements NacinPlacanjaMapper {

    @Override
    public NacinPlacanjaDto map(NacinPlacanja nacinPlacanja) {
            NacinPlacanjaDto dto = new NacinPlacanjaDto();
            BeanUtils.copyProperties(nacinPlacanja, dto);
            return dto;
    }


}
