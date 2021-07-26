package com.pristupni_zadatak.miniwebshop.repository;

import com.pristupni_zadatak.miniwebshop.entity.Brand;
import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

    List<Proizvod> findAllByBrand(Brand brand);

    List<Proizvod> findAllByBrandAndNaziv(Brand brand, String naziv);

    List<Proizvod> findAllByBrandAndNazivAndCijena(Brand brand, String naziv, Double cijena);

    List<Proizvod> findAllByNaziv(String naziv);

    List<Proizvod> findAllByNazivAndCijena(String naziv, Double cijena);

    List<Proizvod> findAllByCijena(Double cijena);

    List<Proizvod> findAllByBrandAndCijena(Brand byNaziv, Double cijena);
}
