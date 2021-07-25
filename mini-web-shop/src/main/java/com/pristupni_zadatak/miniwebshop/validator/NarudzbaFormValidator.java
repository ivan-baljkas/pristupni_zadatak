package com.pristupni_zadatak.miniwebshop.validator;

import com.pristupni_zadatak.miniwebshop.form.NarudzbaForm;

public interface NarudzbaFormValidator {

    void validateCreate(NarudzbaForm form);

    void validateEdit(Long id, NarudzbaForm form);
}
