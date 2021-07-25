package com.pristupni_zadatak.miniwebshop.controller;

import com.pristupni_zadatak.miniwebshop.dto.PopustKodoviDto;
import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import com.pristupni_zadatak.miniwebshop.facade.PopustKodoviFacade;
import com.pristupni_zadatak.miniwebshop.form.PopustKodoviForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/popust-kodovi")
public class PopustKodoviController {

    private final PopustKodoviFacade facade;

    public PopustKodoviController(PopustKodoviFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<PopustKodoviDto> getAll(@RequestParam(required = false) Boolean iskoristen){
        return facade.getAll(iskoristen);
    }

    @GetMapping("/{Id}")
    public PopustKodoviDto get(@PathVariable Long Id){
        return facade.get(Id);
    }

    @PostMapping
    public void create(@RequestBody PopustKodoviForm form){
        facade.create(form);
    }

    @PutMapping("/{Id}")
    public void edit(@PathVariable Long Id, @RequestBody PopustKodoviForm form){
        facade.edit(Id, form);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        facade.delete(Id);
    }
}
