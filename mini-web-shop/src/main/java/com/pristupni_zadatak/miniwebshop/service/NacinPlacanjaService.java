package com.pristupni_zadatak.miniwebshop.service;

import com.pristupni_zadatak.miniwebshop.entity.NacinPlacanja;

import java.util.List;

public interface NacinPlacanjaService {

    List<NacinPlacanja> getAll();

    NacinPlacanja get(Long id);
}
