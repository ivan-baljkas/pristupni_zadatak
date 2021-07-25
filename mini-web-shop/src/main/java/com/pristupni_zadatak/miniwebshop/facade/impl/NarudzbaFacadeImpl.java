package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaDto;
import com.pristupni_zadatak.miniwebshop.entity.Narudzba;
import com.pristupni_zadatak.miniwebshop.facade.NarudzbaFacade;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaForm;
import com.pristupni_zadatak.miniwebshop.mapper.NarudzbaMapper;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaService;
import com.pristupni_zadatak.miniwebshop.validator.NarudzbaFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NarudzbaFacadeImpl implements NarudzbaFacade {

    private final NarudzbaService service;
    private final NarudzbaMapper mapper;
    private final NarudzbaFormValidator formValidator;

    public NarudzbaFacadeImpl(NarudzbaService service, NarudzbaMapper mapper, NarudzbaFormValidator formValidator) {
        this.service = service;
        this.mapper = mapper;
        this.formValidator = formValidator;
    }

    @Override
    public List<NarudzbaDto> getAll() {
        return service.getAll()
                .stream()
                .map(narudzba ->  mapper.map(narudzba)
                ).collect(Collectors.toList());
    }

    @Override
    public NarudzbaDto get(Long id) {
        return Optional.of(service.get(id))
                .map(narudzba->  mapper.map(narudzba)
                ).orElse(null);
    }

    @Override
    public void create(NarudzbaForm form) {
        formValidator.validateCreate(form);

        Narudzba narudzba = new Narudzba();
        BeanUtils.copyProperties(form, narudzba);
        service.create(narudzba);
    }

    @Override
    public void edit(Long id, NarudzbaForm form) {
        formValidator.validateEdit(id, form);

        Narudzba narudzba = new Narudzba();
        BeanUtils.copyProperties(form, narudzba);
        service.edit(id, narudzba);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
