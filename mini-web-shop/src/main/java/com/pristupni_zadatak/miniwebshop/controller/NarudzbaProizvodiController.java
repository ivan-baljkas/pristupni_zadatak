package com.pristupni_zadatak.miniwebshop.controller;

import com.pristupni_zadatak.miniwebshop.dto.NarudzbaDto;
import com.pristupni_zadatak.miniwebshop.dto.NarudzbaProizvodiDto;
import com.pristupni_zadatak.miniwebshop.facade.NarudzbaProizvodiFacade;
import com.pristupni_zadatak.miniwebshop.form.NarudzbaProizvodiForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/narudzba-proizvod")
public class NarudzbaProizvodiController {

    private final NarudzbaProizvodiFacade facade;

    public NarudzbaProizvodiController(NarudzbaProizvodiFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<NarudzbaProizvodiDto> getAll(){
        return facade.getAll();
    }

    @GetMapping("/{Id}")
    public NarudzbaProizvodiDto get(@PathVariable Long Id){
        return facade.get(Id);
    }

    @PostMapping
    public void create(@RequestBody NarudzbaProizvodiForm form){
        facade.create(form);
    }

    @PutMapping("/{Id}")
    public void edit(@PathVariable Long Id, @RequestBody NarudzbaProizvodiForm form){
        facade.edit(Id, form);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        facade.delete(Id);
    }

    @DeleteMapping("/{narudzbaId}/{proizvodId}")
    public void deleteTrenutnaNarudzba(@PathVariable Long narudzbaId,
                                       @PathVariable Long proizvodId){
        facade.deleteTrenutnaNarudzba(narudzbaId, proizvodId);
    }
}
