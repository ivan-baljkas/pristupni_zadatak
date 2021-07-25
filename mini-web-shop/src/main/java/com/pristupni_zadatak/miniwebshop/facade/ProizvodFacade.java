package com.pristupni_zadatak.miniwebshop.facade;

import com.pristupni_zadatak.miniwebshop.dto.ProizvodDto;
import com.pristupni_zadatak.miniwebshop.form.ProizvodForm;

import java.util.List;

public interface ProizvodFacade {
    List<ProizvodDto> getAll();

    ProizvodDto get(Long id);

    void create(ProizvodForm form);

    void edit(Long id, ProizvodForm form);

    void delete(Long id);
}
