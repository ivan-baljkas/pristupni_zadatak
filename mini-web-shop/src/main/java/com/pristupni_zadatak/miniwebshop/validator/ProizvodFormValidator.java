package com.pristupni_zadatak.miniwebshop.validator;


import com.pristupni_zadatak.miniwebshop.form.ProizvodForm;

public interface ProizvodFormValidator {

    void validateCreate(ProizvodForm form);

    void validateEdit(Long id, ProizvodForm form);
}
