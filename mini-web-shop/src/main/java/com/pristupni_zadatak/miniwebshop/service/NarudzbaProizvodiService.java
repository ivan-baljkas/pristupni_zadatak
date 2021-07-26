package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.entity.NarudzbaProizvodi;

import java.util.List;
import java.util.Optional;

public interface NarudzbaProizvodiService {
    boolean existsById(Long proizvodId);

    List<NarudzbaProizvodi> getAll();

    NarudzbaProizvodi get(Long id);

    void create(NarudzbaProizvodi narudzbaProizvodi);

    void edit(Long id, NarudzbaProizvodi narudzbaProizvodi);

    void delete(Long id);

    void deleteTrenutnaNarudzba(Long narudzbaId, Long proizvodId);
}
