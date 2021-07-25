package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaProizvodiDto;
import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;
import com.pristupni_zadatak.miniwebshop.facade.NarudzbaProizvodiFacade;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaProizvodiForm;
import com.pristupni_zadatak.miniwebshop.mapper.NarudzbaProizvodiMapper;
import com.pristupni_zadatak.miniwebshop.service.NarudzbaProizvodiService;
import com.pristupni_zadatak.miniwebshop.validator.NarudzbaProizvodiFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NarudzbaProizvodiFacadeImpl implements NarudzbaProizvodiFacade {

    private final NarudzbaProizvodiService service;
    private final NarudzbaProizvodiFormValidator formValidator;
    private final NarudzbaProizvodiMapper mapper;

    public NarudzbaProizvodiFacadeImpl(NarudzbaProizvodiService service, NarudzbaProizvodiFormValidator formValidator, NarudzbaProizvodiMapper mapper) {
        this.service = service;
        this.formValidator = formValidator;
        this.mapper = mapper;
    }

    @Override
    public List<NarudzbaProizvodiDto> getAll() {
        return service.getAll()
                .stream()
                .map(np ->  mapper.map(np)
                ).collect(Collectors.toList());
    }

    @Override
    public NarudzbaProizvodiDto get(Long id) {
        return Optional.of(service.get(id))
                .map(np ->  mapper.map(np)
                ).orElse(null);
    }

    @Override
    public void create(NarudzbaProizvodiForm form) {
        formValidator.validateCreate(form);

        NarudzbaProizvodi narudzbaProizvodi = new NarudzbaProizvodi();
        BeanUtils.copyProperties(form, narudzbaProizvodi);
        service.create(narudzbaProizvodi);
    }

    @Override
    public void edit(Long id, NarudzbaProizvodiForm form) {
        formValidator.validateEdit(id, form);

        NarudzbaProizvodi narudzbaProizvodi = new NarudzbaProizvodi();
        BeanUtils.copyProperties(form, narudzbaProizvodi);
        service.edit(id, narudzbaProizvodi);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
