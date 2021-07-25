package com.pristupni_zadatak.miniwebshop.facade.impl;

import com.pristupni_zadatak.miniwebshop.facade.PopustKodoviFacade;
import com.pristupni_zadatak.miniwebshop.service.PopustKodoviService;
import org.springframework.stereotype.Component;

@Component
public class PopustKodoviFacadeImpl implements PopustKodoviFacade {

    private final PopustKodoviService service;

    public PopustKodoviFacadeImpl(PopustKodoviService service) {
        this.service = service;
    }
}
