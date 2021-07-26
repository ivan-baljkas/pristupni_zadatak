package com.pristupni_zadatak.miniwebshop.controller;
import com.pristupni_zadatak.miniwebshop.dto.ProizvodDto;
import com.pristupni_zadatak.miniwebshop.facade.ProizvodFacade;
import com.pristupni_zadatak.miniwebshop.form.ProizvodForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proizvod")
public class ProizvodController {

    private final ProizvodFacade facade;

    public ProizvodController(ProizvodFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<ProizvodDto> getAll(@RequestParam(required = false) String brand,
                                    @RequestParam(required = false) String naziv,
                                    @RequestParam(required = false) Double cijena){
        return facade.getAll(brand, naziv, cijena);
    }

    @GetMapping("/{Id}")
    public ProizvodDto get(@PathVariable Long Id){
        return facade.get(Id);
    }

    @PostMapping
    public void create(@RequestBody ProizvodForm form){
        facade.create(form);
    }

    @PutMapping("/{Id}")
    public void edit(@PathVariable Long Id, @RequestBody ProizvodForm form){
        facade.edit(Id, form);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        facade.delete(Id);
    }
}
