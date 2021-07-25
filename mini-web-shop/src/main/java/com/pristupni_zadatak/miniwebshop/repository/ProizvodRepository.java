package com.pristupni_zadatak.miniwebshop.repository;

import com.pristupni_zadatak.miniwebshop.entity.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {
}
