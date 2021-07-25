package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import com.pristupni_zadatak.miniwebshop.validator.PopustKodoviFormValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PopustKodoviFormValidatorImpl implements PopustKodoviFormValidator {

   private final PopustKodoviService service;

    public PopustKodoviFormValidatorImpl(PopustKodoviService service) {
        this.service = service;
    }

    @Override
    public void validateCreate(PopustKodoviForm form) {

        Assert.notNull(form, "Uneseni Popust kod ne smije biti null.");
        Assert.hasText(form.getKod(),"Atribut KOD ne smije biti prazan.");
        Assert.notNull(form.getPopust(), "Atribut POPUST mora biti zadan.");
        Assert.notNull(form.getIskoristen(), "Atribut ISKORISTEN mora biti zadan.");

        if(form.getPopust()<0 || form.getPopust()>1){
            throw new ValidationException("Popust treba biti broj između 0 i 1.");
        }
    }

    @Override
    public void validateEdit(Long id, PopustKodoviForm form) {

        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji entitet PopustKodovi koji ima id: "+id);
        }

        Assert.notNull(form, "Uneseni Popust kod ne smije biti null.");
        Assert.hasText(form.getKod(),"Atribut KOD ne smije biti prazan.");
        Assert.notNull(form.getPopust(), "Atribut POPUST mora biti zadan.");
        Assert.notNull(form.getIskoristen(), "Atribut ISKORISTEN mora biti zadan.");

        if(form.getPopust()<0 || form.getPopust()>1){
            throw new ValidationException("Popust treba biti broj između 0 i 1.");
        }

    }
}
