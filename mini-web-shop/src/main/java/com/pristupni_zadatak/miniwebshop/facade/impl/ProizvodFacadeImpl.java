package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.ProizvodDto;
import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import com.pristupni_zadatak.miniwebshop.facade.ProizvodFacade;
import com.pristupni_zadatak.miniwebshop.form.ProizvodForm;
import com.pristupni_zadatak.miniwebshop.mapper.ProizvodMapper;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import com.pristupni_zadatak.miniwebshop.validator.ProizvodFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProizvodFacadeImpl implements ProizvodFacade {

    private final ProizvodService service;
    private final ProizvodMapper mapper;
    private final ProizvodFormValidator formValidator;

    public ProizvodFacadeImpl(ProizvodService service, ProizvodMapper mapper, ProizvodFormValidator formValidator) {
        this.service = service;
        this.mapper = mapper;
        this.formValidator = formValidator;
    }

    @Override
    public List<ProizvodDto> getAll(String brand, String naziv, Double cijena) {
        return service.getAll(brand, naziv, cijena)
                .stream()
                .map(proizvod ->  mapper.map(proizvod)
                ).collect(Collectors.toList());
    }

    @Override
    public ProizvodDto get(Long id) {
        return Optional.of(service.get(id))
                .map(proizvod ->  mapper.map(proizvod)
                ).orElse(null);
    }

    @Override
    public void create(ProizvodForm form) {
        formValidator.validateCreate(form);

        Proizvod proizvod = new Proizvod();
        BeanUtils.copyProperties(form, proizvod);
        service.create(proizvod);
    }

    @Override
    public void edit(Long id, ProizvodForm form) {
        formValidator.validateEdit(id, form);

        Proizvod proizvod = new Proizvod();
        BeanUtils.copyProperties(form, proizvod);
        service.edit(id, proizvod);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
