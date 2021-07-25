package com.pristupni_zadatak.miniwebshop.facade;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaProizvodiDto;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaProizvodiForm;

import java.util.List;

public interface NarudzbaProizvodiFacade {
    List<NarudzbaProizvodiDto> getAll();

    NarudzbaProizvodiDto get(Long id);

    void create(NarudzbaProizvodiForm form);

    void edit(Long id, NarudzbaProizvodiForm form);

    void delete(Long id);
}
