package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.dto.PopustKodoviDto;
import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;

import java.util.List;

public interface PopustKodoviService {

    boolean existsById(Long id);

    List<PopustKodovi> getAll(Boolean iskoristen);

    PopustKodovi get(Long id);

    void create(PopustKodovi popustKodovi);

    void delete(Long id);

    void edit(Long id, PopustKodovi popustKodovi);
}
