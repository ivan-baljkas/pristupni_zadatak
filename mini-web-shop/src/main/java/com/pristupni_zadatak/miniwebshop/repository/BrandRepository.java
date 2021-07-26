package com.pristupni_zadatak.miniwebshop.repository;

import com.pristupni_zadatak.miniwebshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    boolean existsByNaziv(String naziv);

    boolean existsByNazivAndIdNot(String naziv, Long id);

    Brand findByNaziv(String naziv);
}
