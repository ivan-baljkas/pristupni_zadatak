package com.pristupni_zadatak.miniwebshop.controller;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaDto;
import com.pristupni_zadatak.miniwebshop.facade.NarudzbaFacade;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/narudzba")
public class NarudzbaController {

    private final NarudzbaFacade facade;

    public NarudzbaController(NarudzbaFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<NarudzbaDto> getAll(){
        return facade.getAll();
    }

    @GetMapping("/{Id}")
    public NarudzbaDto get(@PathVariable Long Id){
        return facade.get(Id);
    }

    @PostMapping
    public void create(@RequestBody NarudzbaForm form){
        facade.create(form);
    }

    @PutMapping("/{Id}")
    public void edit(@PathVariable Long Id, @RequestBody NarudzbaForm form){
        facade.edit(Id, form);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        facade.delete(Id);
    }
}
