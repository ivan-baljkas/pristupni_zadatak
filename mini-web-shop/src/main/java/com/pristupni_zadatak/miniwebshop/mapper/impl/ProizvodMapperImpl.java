package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.ProizvodDto;
import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import com.pristupni_zadatak.miniwebshop.mapper.ProizvodMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProizvodMapperImpl implements ProizvodMapper {

    @Override
    public ProizvodDto map(Proizvod proizvod) {
        ProizvodDto dto = new ProizvodDto();
        BeanUtils.copyProperties(proizvod,dto);
        dto.setBrand(proizvod.getBrand().getNaziv());
        return dto;
    }
}
