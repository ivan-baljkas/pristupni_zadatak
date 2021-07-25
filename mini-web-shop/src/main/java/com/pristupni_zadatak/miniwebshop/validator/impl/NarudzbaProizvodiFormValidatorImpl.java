package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaProizvodiForm;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaProizvodiService;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import com.pristupni_zadatak.miniwebshop.validator.NarudzbaProizvodiFormValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class NarudzbaProizvodiFormValidatorImpl implements NarudzbaProizvodiFormValidator {

    private final NarudzbaProizvodiService service;
    private final ProizvodService proizvodService;

    public NarudzbaProizvodiFormValidatorImpl(NarudzbaProizvodiService service, ProizvodService proizvodService) {
        this.service = service;
        this.proizvodService = proizvodService;
    }

    @Override
    public void validateCreate(NarudzbaProizvodiForm form) {
        Assert.notNull(form, "Uneseni Entitet kod ne smije biti null.");
        Assert.notNull(form.getNarudzbaId(),"Atribut NARUDZBA_ID ne smije biti prazan.");
        Assert.notNull(form.getProizvodId(), "Atribut PROIZVOD_ID mora biti zadan.");

        if(!proizvodService.existsById(form.getProizvodId())){
            throw new ValidationException("Ne postoji proizvod sa id-om:"+ form.getProizvodId());
        }
    }

    @Override
    public void validateEdit(Long id, NarudzbaProizvodiForm form) {

        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji Entitet sa id-om:"+ id);
        }

        Assert.notNull(form, "Uneseni Entitet kod ne smije biti null.");
        Assert.notNull(form.getNarudzbaId(),"Atribut NARUDZBA_ID ne smije biti prazan.");
        Assert.notNull(form.getProizvodId(), "Atribut PROIZVOD_ID mora biti zadan.");

        if(!proizvodService.existsById(form.getProizvodId())){
            throw new ValidationException("Ne postoji proizvod sa id-om:"+ form.getProizvodId());
        }
    }
}
