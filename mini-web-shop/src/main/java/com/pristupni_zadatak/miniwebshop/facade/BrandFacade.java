package com.pristupni_zadatak.miniwebshop.facade;
import com.pristupni_zadatak.miniwebshop.dto.BrandDto;
import com.pristupni_zadatak.miniwebshop.form.BrandForm;
import java.util.List;

public interface BrandFacade {

    List<BrandDto> getAll();

    BrandDto get(Long id);

    void create(BrandForm form);

    void edit(Long id, BrandForm form);

    void delete(Long id);
}
