package com.pristupni_zadatak.miniwebshop.validator.impl;

import com.pristupni_zadatak.miniwebshop.exception.ValidationException;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaForm;
import com.pristupni_zadatak.miniwebshop.service.NacinPlacanjaService;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaService;
import com.pristupni_zadatak.miniwebshop.validator.NarudzbaFormValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class NarudzbaFormValidatorImpl implements NarudzbaFormValidator {

    private final NarudzbaService service;

    private final NacinPlacanjaService nacinPlacanjaService;

    public NarudzbaFormValidatorImpl(NarudzbaService service, NacinPlacanjaService nacinPlacanjaService) {
        this.service = service;
        this.nacinPlacanjaService = nacinPlacanjaService;
    }

    @Override
    public void validateCreate(NarudzbaForm form) {

        Assert.notNull(form, "Unesena Narudzba kod ne smije biti null.");
        Assert.hasText(form.getNapomena(),"Atribut NAPOMENA ne smije biti prazan.");
        Assert.notNull(form.getDatum(), "Atribut DATUM mora biti zadan.");
        Assert.notNull(form.getNacinPlacanjaId(), "Atribut NACIN_PLACANJA mora biti zadan.");
        Assert.hasText(form.getEmail(), "Atribut EMAIL mora biti zadan.");
        Assert.notNull(form.getBrojMobitela(), "Atribut BROJ_MOBITELA mora biti zadan.");
        Assert.hasText(form.getAdresaDostave(), "Atribut ADRESA_DOSTAVE mora biti zadan.");

        if(nacinPlacanjaService.get(form.getNacinPlacanjaId()).getNaziv().toUpperCase().equals("KARTIČNO")){
            if(form.getBrojKartice() == null)
            throw new ValidationException("Ako je odabrano kartično plaćanje, potreban je broj kartice.");
        }
    }

    @Override
    public void validateEdit(Long id, NarudzbaForm form) {

        if(!service.existsById(id)){
            throw new ValidationException("Ne postoji Narudzba koja ima id: "+id);
        }

        Assert.notNull(form, "Unesena Narudzba kod ne smije biti null.");
        Assert.hasText(form.getNapomena(),"Atribut NAPOMENA ne smije biti prazan.");
        Assert.notNull(form.getDatum(), "Atribut DATUM mora biti zadan.");
        Assert.notNull(form.getNacinPlacanjaId(), "Atribut NACIN_PLACANJA mora biti zadan.");
        Assert.hasText(form.getEmail(), "Atribut EMAIL mora biti zadan.");
        Assert.notNull(form.getBrojMobitela(), "Atribut BROJ_MOBITELA mora biti zadan.");
        Assert.hasText(form.getAdresaDostave(), "Atribut ADRESA_DOSTAVE mora biti zadan.");

        if(nacinPlacanjaService.get(form.getNacinPlacanjaId()).getNaziv().toUpperCase().equals("KARTIČNO")){
            if(form.getBrojKartice() == null)
                throw new ValidationException("Ako je odabrano kartično plaćanje, potreban je broj kartice.");
        }

    }
}
