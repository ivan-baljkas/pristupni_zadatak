package com.pristupni_zadatak.miniwebshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "NARUDZBA_PROIZVODI")
public class NarudzbaProizvodi {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NARUDZBA_ID")
    private Long narudzbaId;

    @Column(name = "PROIZVOD_ID")
    private Long proizvodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NARUDZBA_ID", insertable = false, updatable = false)
    private Narudzba narudzba;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROIZVOD_ID", insertable = false, updatable = false)
    private Proizvod proizvod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNarudzbaId() {
        return narudzbaId;
    }

    public void setNarudzbaId(Long narudzbaId) {
        this.narudzbaId = narudzbaId;
    }

    public Long getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(Long proizvodId) {
        this.proizvodId = proizvodId;
    }

    public Narudzba getNarudzba() {
        return narudzba;
    }

    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
