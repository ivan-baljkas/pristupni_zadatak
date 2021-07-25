package com.pristupni_zadatak.miniwebshop.facade;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaDto;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaForm;

import java.util.List;

public interface NarudzbaFacade {
    List<NarudzbaDto> getAll();

    NarudzbaDto get(Long id);

    void create(NarudzbaForm form);

    void edit(Long id, NarudzbaForm form);

    void delete(Long id);
}
