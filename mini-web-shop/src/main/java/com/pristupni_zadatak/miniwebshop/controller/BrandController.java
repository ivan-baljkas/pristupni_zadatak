package com.pristupni_zadatak.miniwebshop.controller;
import com.pristupni_zadatak.miniwebshop.dto.BrandDto;
import com.pristupni_zadatak.miniwebshop.facade.BrandFacade;
import com.pristupni_zadatak.miniwebshop.form.BrandForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandFacade facade;

    public BrandController(BrandFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<BrandDto> getAll(){
        return facade.getAll();
    }

    @GetMapping("/{Id}")
    public BrandDto get(@PathVariable Long Id){
        return facade.get(Id);
    }

    @PostMapping
    public void create(@RequestBody BrandForm form){
        facade.create(form);
    }

    @PutMapping("/{Id}")
    public void edit(@PathVariable Long Id, @RequestBody BrandForm form){
        facade.edit(Id, form);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        facade.delete(Id);
    }
}
