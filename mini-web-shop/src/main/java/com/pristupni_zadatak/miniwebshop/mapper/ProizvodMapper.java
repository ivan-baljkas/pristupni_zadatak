package com.pristupni_zadatak.miniwebshop.mapper;

import com.pristupni_zadatak.miniwebshop.dto.ProizvodDto;
import com.pristupni_zadatak.miniwebshop.entity.Proizvod;

public interface ProizvodMapper {

    ProizvodDto map(Proizvod proizvod);
}
