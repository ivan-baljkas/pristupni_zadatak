package com.pristupni_zadatak.miniwebshop.mapper.impl;

import com.pristupni_zadatak.miniwebshop.dto.PopustKodoviDto;
import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import com.pristupni_zadatak.miniwebshop.mapper.PopustKodoviMapper;
import org.springframework.stereotype.Component;

@Component
public class PopustKodoviMapperImpl implements PopustKodoviMapper {

    @Override
    public PopustKodoviDto map(PopustKodovi popustKodovi) {
        PopustKodoviDto dto = new PopustKodoviDto();
        dto.setIskoristen(popustKodovi.getIskoristen());
        dto.setKod(popustKodovi.getKod());
        dto.setPopust(popustKodovi.getPopust());
        return dto;
    }
}
