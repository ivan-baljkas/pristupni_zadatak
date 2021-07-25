package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import com.pristupni_zadatak.miniwebshop.validator.PopustKodoviFormValidator;
import org.springframework.util.Assert;

import java.util.Objects;

public class PopustKodoviFormValidatorImpl implements PopustKodoviFormValidator {

   private final PopustKodoviService service;

    public PopustKodoviFormValidatorImpl(PopustKodoviService service) {
        this.service = service;
    }

    @Override
    public void validateCreate(PopustKodoviForm form) {

        Assert.notNull(form, "Uneseni Popust kod ne smije biti null.");
        Assert.hasText(form.getKod(),"Atribut KOD ne smije biti prazan.");
        Assert.notNull(form, "Atribut POPUST mora biti zadan.");
        Assert.notNull(form.getIskoristen(), "Atribut ISKORISTEN mora biti zadan.");

    }

    @Override
    public void validatEdit(Long id, PopustKodoviForm form) {

        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji entitet PopustKodovi koji je potrebno ažurirati");
        }

        Assert.notNull(form, "Uneseni Popust kod ne smije biti null.");
        Assert.hasText(form.getKod(),"Atribut KOD ne smije biti prazan.");
        Assert.notNull(form, "Atribut POPUST mora biti zadan.");
        Assert.notNull(form.getIskoristen(), "Atribut ISKORISTEN mora biti zadan.");

    }
}
