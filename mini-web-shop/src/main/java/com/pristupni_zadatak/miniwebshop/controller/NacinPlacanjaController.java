package com.pristupni_zadatak.miniwebshop.controller;

import com.pristupni_zadatak.miniwebshop.dto.NacinPlacanjaDto;
import com.pristupni_zadatak.miniwebshop.facade.NacinPlacanjaFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nacin-placanja")
public class NacinPlacanjaController {

    private final NacinPlacanjaFacade facade;

    public NacinPlacanjaController(NacinPlacanjaFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<NacinPlacanjaDto> getAll(){
        return facade.getAll();
    }

    @GetMapping("/{Id}")
    public NacinPlacanjaDto get(@PathVariable Long Id){
        return facade.get(Id);
    }
}
