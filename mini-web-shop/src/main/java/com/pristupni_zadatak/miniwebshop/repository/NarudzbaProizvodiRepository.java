package com.pristupni_zadatak.miniwebshop.repository;

import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NarudzbaProizvodiRepository extends JpaRepository<NarudzbaProizvodi, Long> {

    List<NarudzbaProizvodi> findAllByNarudzbaId(Long narudzbaId);

    NarudzbaProizvodi findFirstByNarudzbaIdAndProizvodId(Long narudzbaId, Long proizvodId);
}
