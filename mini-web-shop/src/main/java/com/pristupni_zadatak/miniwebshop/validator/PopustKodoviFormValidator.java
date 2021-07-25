package com.pristupni_zadatak.miniwebshop.validator;

import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;

public interface PopustKodoviFormValidator {

    void validateCreate(PopustKodoviForm form);

    void validatEdit(Long id, PopustKodoviForm form);
}
