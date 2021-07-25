package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.BrandForm;
import com.pristupni_zadatak.miniwebshop.service.BrandService;
import com.pristupni_zadatak.miniwebshop.validator.BrandFormValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BrandFormValidatorImpl implements BrandFormValidator {

    private final BrandService service;

    public BrandFormValidatorImpl(BrandService brandService) {
        this.service = brandService;
    }

    @Override
    public void validateCreate(BrandForm form) {
        Assert.notNull(form, "Uneseni Brand ne smije biti null.");
        Assert.hasText(form.getNaziv(),"Atribut NAZIV ne smije biti prazan.");

        if(service.existsByNaziv(form.getNaziv())){
            throw new ValidationException("Već postoji Brand s nazivom:  "+form.getNaziv());
        }
    }

    @Override
    public void validateEdit(Long id, BrandForm form) {
        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji entitet Brand koji ima id: "+id);
        }

        Assert.notNull(form, "Uneseni Brand ne smije biti null.");
        Assert.hasText(form.getNaziv(),"Atribut NAZIV ne smije biti prazan.");

        if(service.existsByNazivAndIdNot(form.getNaziv(), id)){
            throw new ValidationException("Već postoji drugi Brand s nazivom:  "+form.getNaziv());
        }
    }
}
