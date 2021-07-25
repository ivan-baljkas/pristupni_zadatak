package com.pristupni_zadatak.miniwebshop.repository;

import com.pristupni_zadatak.miniwebshop.entity.PopustKodovi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PopustKodoviRepository extends JpaRepository<PopustKodovi, Long> {

    List<PopustKodovi> findAllByIskoristen(Boolean iskoristen);
}
