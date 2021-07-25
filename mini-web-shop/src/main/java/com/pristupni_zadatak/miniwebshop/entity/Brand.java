package com.pristupni_zadatak.miniwebshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BRAND")
public class Brand {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAZIV")
    private String naziv;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Proizvod> proizvodi;

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

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
