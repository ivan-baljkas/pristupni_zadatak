package com.pristupni_zadatak.miniwebshop.entity;

import javax.persistence.*;

@Entity
@Table(name="POPUST_KODOVI")
public class PopustKodovi {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KOD")
    private String kod;

    @Column(name = "POPUST")
    private Double popust;

    @Column(name = "ISKORISTEN")
    private Boolean iskoristen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}