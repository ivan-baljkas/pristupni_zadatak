package com.pristupni_zadatak.miniwebshop.entity;

import javax.persistence.*;

@Entity
@Table(name="NACIN_PLACANJA")
public class NacinPlacanja {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
