package com.pristupni_zadatak.miniwebshop.service.impl;

import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import com.pristupni_zadatak.miniwebshop.repository.ProizvodRepository;
import com.pristupni_zadatak.miniwebshop.service.BrandService;
import com.pristupni_zadatak.miniwebshop.service.ProizvodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements ProizvodService {

    private final ProizvodRepository repository;

    private final BrandService brandService;

    public ProizvodServiceImpl(ProizvodRepository repository, BrandService brandService) {
        this.repository = repository;
        this.brandService = brandService;
    }

    @Override
    public List<Proizvod> getAll(String brand, String naziv, Double cijena) {

        if(brand!=null && naziv==null && cijena==null){
            return repository.findAllByBrand(brandService.findByNaziv(brand));
        }
        if(brand!=null && naziv!=null && cijena==null){
            return repository.findAllByBrandAndNaziv(brandService.findByNaziv(brand), naziv);
        }
        if(brand!=null && naziv!=null && cijena!=null){
            return repository.findAllByBrandAndNazivAndCijena(brandService.findByNaziv(brand), naziv, cijena);
        }
        if(brand==null && naziv!=null && cijena==null){
            return repository.findAllByNaziv(naziv);
        }
        if(brand==null && naziv!=null && cijena!=null){
            return repository.findAllByNazivAndCijena(naziv, cijena);
        }
        if(brand==null && naziv==null && cijena!=null){
            return repository.findAllByCijena(cijena);
        }
        if(brand!=null && naziv==null && cijena!=null){
            return repository.findAllByBrandAndCijena(brandService.findByNaziv(brand), cijena);
        }

        return repository.findAll();
    }

    @Override
    public Proizvod get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji Proizvod koji ima id: "+id));
    }

    @Override
    public void create(Proizvod proizvod) {
        repository.save(proizvod);
    }

    @Override
    public void edit(Long id, Proizvod proizvod) {
        proizvod.setId(id);
        repository.save(proizvod);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
