package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.BrandDto;
import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.entity.Brand;
import com.pristupni_zadatak.miniwebshop.mapper.BrandMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BrandMapperImpl implements BrandMapper{
    @Override
    public BrandDto map(Brand brand) {
        BrandDto dto = new BrandDto();
        BeanUtils.copyProperties(brand, dto);
        return dto;
    }
}
