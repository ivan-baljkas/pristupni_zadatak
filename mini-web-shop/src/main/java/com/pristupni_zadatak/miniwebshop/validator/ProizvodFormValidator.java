package com.pristupni_zadatak.miniwebshop.validator;

import com.pristupni_zadatak.miniwebshop.form.BrandForm;

public interface ProizvodFormValidator {

    void validateCreate(BrandForm form);

    void validateEdit(Long id, BrandForm form);
}
