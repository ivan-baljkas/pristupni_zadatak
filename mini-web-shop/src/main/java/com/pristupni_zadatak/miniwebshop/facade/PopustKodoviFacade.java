package com.pristupni_zadatak.miniwebshop.facade;

import com.pristupni_zadatak.miniwebshop.dto.PopustKodoviDto;
import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;

import java.util.List;

public interface PopustKodoviFacade {

    List<PopustKodoviDto> getAll(Boolean iskoristen);

    PopustKodoviDto get(Long id);

    void create(PopustKodoviForm form);

    void edit(Long id, PopustKodoviForm form);

    void delete(Long id);

    PopustKodoviDto getByKod(String kod);
}
