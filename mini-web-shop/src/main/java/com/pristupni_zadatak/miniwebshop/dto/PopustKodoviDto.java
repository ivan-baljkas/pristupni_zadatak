package com.pristupni_zadatak.miniwebshop.dto;

import javax.persistence.Column;

public class PopustKodoviDto {

    private Long id;

    private String kod;

    private Double popust;

    private Boolean iskoristen;

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Double getPopust() {
        return popust;
    }

    public void setPopust(Double popust) {
        this.popust = popust;
    }

    public Boolean getIskoristen() {
        return iskoristen;
    }

    public void setIskoristen(Boolean iskoristen) {
        this.iskoristen = iskoristen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
