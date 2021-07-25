package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.PopustKodoviDto;
import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import com.pristupni_zadatak.miniwebshop.facade.PopustKodoviFacade;
import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;
import com.pristupni_zadatak.miniwebshop.mapper.PopustKodoviMapper;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import com.pristupni_zadatak.miniwebshop.validator.PopustKodoviFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PopustKodoviFacadeImpl implements PopustKodoviFacade {

    private final PopustKodoviService service;
    private final PopustKodoviMapper mapper;
    private final PopustKodoviFormValidator formValidator;

    public PopustKodoviFacadeImpl(PopustKodoviService service, PopustKodoviMapper mapper, PopustKodoviFormValidator formValidator) {
        this.service = service;
        this.mapper = mapper;
        this.formValidator = formValidator;
    }

    @Override
    public List<PopustKodoviDto> getAll(Boolean iskoristen) {
        return service.getAll(iskoristen)
                .stream()
                .map(popustKodovi ->  mapper.map(popustKodovi)
                ).collect(Collectors.toList());
    }

    @Override
    public PopustKodoviDto get(Long id) {
        return Optional.of(service.get(id))
                .map(popustKodovi ->  mapper.map(popustKodovi)
                ).orElse(null);
    }

    @Override
    public void create(PopustKodoviForm form) {
        formValidator.validateCreate(form);

        PopustKodovi popustKodovi = new PopustKodovi();
        BeanUtils.copyProperties(form, popustKodovi);
        service.create(popustKodovi);
    }

    @Override
    public void edit(Long id, PopustKodoviForm form) {
        formValidator.validateEdit(id, form);

        PopustKodovi popustKodovi = new PopustKodovi();
        BeanUtils.copyProperties(form, popustKodovi);
        service.edit(id, popustKodovi);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
