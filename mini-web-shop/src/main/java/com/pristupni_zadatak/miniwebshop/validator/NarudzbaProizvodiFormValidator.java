package com.pristupni_zadatak.miniwebshop.validator;

import com.pristupni_zadatak.miniwebshop.form.NarudzbaProizvodiForm;

public interface NarudzbaProizvodiFormValidator {

    void validateCreate(NarudzbaProizvodiForm form);

    void validateEdit(Long id, NarudzbaProizvodiForm form);
}
