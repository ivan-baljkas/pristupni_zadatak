package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaDto;
import com.pristupni_zadatak.miniwebshop.entity.Narudzba;
import com.pristupni_zadatak.miniwebshop.mapper.NarudzbaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NarudzbaMapperImpl implements NarudzbaMapper {
    @Override
    public NarudzbaDto map(Narudzba narudzba) {
        NarudzbaDto dto = new NarudzbaDto();
        BeanUtils.copyProperties(narudzba,dto);
        return dto;
    }
}
