package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.ProizvodForm;
import com.pristupni_zadatak.miniwebshop.service.BrandService;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import com.pristupni_zadatak.miniwebshop.validator.ProizvodFormValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ProizvodFormValidatorImpl implements ProizvodFormValidator {

    private final ProizvodService service;
    private final BrandService brandService;

    public ProizvodFormValidatorImpl(ProizvodService service, BrandService brandService) {
        this.service = service;
        this.brandService = brandService;
    }

    @Override
    public void validateCreate(ProizvodForm form) {
        Assert.notNull(form, "Uneseni Proizvod ne smije biti null.");

        Assert.hasText(form.getNaziv(),"Atribut NAZIV ne smije biti prazan.");
        Assert.hasText(form.getOpis(),"Atribut OPIS ne smije biti prazan.");
        Assert.notNull(form.getCijena(), "Atribut CIJENA ne smije biti prazan.");
        Assert.notNull(form.getKolicina(), "Atribut KOLICINA ne smije biti prazan.");
        Assert.notNull(form.getBrandId(), "Atribut BRAND_ID ne smije biti prazan.");

        Assert.isTrue(form.getCijena()>=0, "Cijena mora biti veća ili jednaka 0.");
        Assert.isTrue(form.getKolicina()>=0, "Kolicina mora biti veća ili jednaka 0.");
        if(!brandService.existsById(form.getBrandId())){
            throw new ValidationException("Ne postoji Brand s nazivom:  "+form.getNaziv());
        }
    }

    @Override
    public void validateEdit(Long id, ProizvodForm form) {

        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji Brand koji ima id:  "+id);
        }

        Assert.notNull(form, "Uneseni Proizvod ne smije biti null.");

        Assert.hasText(form.getNaziv(),"Atribut NAZIV ne smije biti prazan.");
        Assert.hasText(form.getOpis(),"Atribut OPIS ne smije biti prazan.");
        Assert.notNull(form.getCijena(), "Atribut CIJENA ne smije biti prazan.");
        Assert.notNull(form.getKolicina(), "Atribut KOLICINA ne smije biti prazan.");
        Assert.notNull(form.getBrandId(), "Atribut BRAND_ID ne smije biti prazan.");

        Assert.isTrue(form.getCijena()>=0, "Cijena mora biti veća ili jednaka 0.");
        Assert.isTrue(form.getKolicina()>=0, "Kolicina mora biti veća ili jednaka 0.");
        if(!brandService.existsById(form.getBrandId())){
            throw new ValidationException("Ne postoji Brand s nazivom:  "+form.getNaziv());
        }
    }
}
