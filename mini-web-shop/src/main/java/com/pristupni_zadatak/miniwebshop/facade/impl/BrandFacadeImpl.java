package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.dto.BrandDto;
import com.pristupni_zadatak.miniwebshop.entity.Brand;
import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import com.pristupni_zadatak.miniwebshop.facade.BrandFacade;
import com.pristupni_zadatak.miniwebshop.form.BrandForm;
import com.pristupni_zadatak.miniwebshop.mapper.BrandMapper;
import com.pristupni_zadatak.miniwebshop.service.BrandService;
import com.pristupni_zadatak.miniwebshop.validator.BrandFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandFacadeImpl implements BrandFacade {

    private final BrandService service;
    private final BrandMapper mapper;
    private final BrandFormValidator formValidator;

    public BrandFacadeImpl(BrandService service, BrandMapper mapper, BrandFormValidator formValidator) {
        this.service = service;
        this.mapper = mapper;
        this.formValidator = formValidator;
    }

    @Override
    public List<BrandDto> getAll() {
        return service.getAll()
                .stream()
                .map(brand ->  mapper.map(brand)
                ).collect(Collectors.toList());
    }

    @Override
    public BrandDto get(Long id) {
        return Optional.of(service.get(id))
                .map(brand ->  mapper.map(brand)
                ).orElse(null);
    }

    @Override
    public void create(BrandForm form) {
        formValidator.validateCreate(form);

        Brand brand = new Brand();
        BeanUtils.copyProperties(form, brand);
        service.create(brand);
    }

    @Override
    public void edit(Long id, BrandForm form) {
        formValidator.validateEdit(id, form);

        Brand brand = new Brand();
        BeanUtils.copyProperties(form, brand);
        service.edit(id, brand);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
