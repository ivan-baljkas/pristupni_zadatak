package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaProizvodiDto;
import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;
import com.pristupni_zadatak.miniwebshop.mapper.NarudzbaProizvodiMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NarudzbaProizvodiMapperImpl implements NarudzbaProizvodiMapper {

    @Override
    public NarudzbaProizvodiDto map(NarudzbaProizvodi narudzbaProizvodi) {
        NarudzbaProizvodiDto dto = new NarudzbaProizvodiDto();
        BeanUtils.copyProperties(narudzbaProizvodi, dto);
        return dto;
    }
}
