package com.pristupni_zadatak.miniwebshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NARUDZBA")
public class Narudzba {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATUM")
    private LocalDate datum;

    @Column(name = "UKUPNA_CIJENA_BEZ_P")
    private double ukupnaCijenaBezP;

    @Column(name = "UKUPNA_CIJENA_S_P")
    private double ukupnaCijenaSP;

    @Column(name = "KOD_ZA_POPUST_ID")
    private Long kodZaPopustId;

    @Column(name = "NACIN_PLACANJA_ID")
    private Long nacinPlacanjaId;

    @Column(name = "BROJ_KARTICE")
    private String brojKartice;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BROJ_MOBITELA")
    private Long brojMobitela;

    @Column(name = "ADRESA_DOSTAVE")
    private String adresaDostave;

    @Column(name = "NAPOMENA")
    private String napomena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KOD_ZA_POPUST_ID", insertable = false, updatable = false)
    private PopustKodovi kodZaPopust;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NACIN_PLACANJA_ID", insertable = false, updatable = false)
    private NacinPlacanja nacinPlacanja;

    @OneToMany(mappedBy = "narudzba", fetch = FetchType.LAZY)
    private List<NarudzbaProizvodi> narudzbaProizvodi;

    public List<NarudzbaProizvodi> getNarudzbaProizvodi() {
        return narudzbaProizvodi;
    }

    public void setNarudzbaProizvodi(List<NarudzbaProizvodi> narudzbaProizvodi) {
        this.narudzbaProizvodi = narudzbaProizvodi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getUkupnaCijenaBezP() {
        return ukupnaCijenaBezP;
    }

    public void setUkupnaCijenaBezP(double ukupnaCijenaBezP) {
        this.ukupnaCijenaBezP = ukupnaCijenaBezP;
    }

    public double getUkupnaCijenaSP() {
        return ukupnaCijenaSP;
    }

    public void setUkupnaCijenaSP(double ukupnaCijenaSP) {
        this.ukupnaCijenaSP = ukupnaCijenaSP;
    }

    public Long getKodZaPopustId() {
        return kodZaPopustId;
    }

    public void setKodZaPopustId(Long kodZaPopustId) {
        this.kodZaPopustId = kodZaPopustId;
    }

    public Long getNacinPlacanjaId() {
        return nacinPlacanjaId;
    }

    public void setNacinPlacanjaId(Long nacinPlacanjaId) {
        this.nacinPlacanjaId = nacinPlacanjaId;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(Long brojMobitela) {
        this.brojMobitela = brojMobitela;
    }

    public String getAdresaDostave() {
        return adresaDostave;
    }

    public void setAdresaDostave(String adresaDostave) {
        this.adresaDostave = adresaDostave;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public PopustKodovi getKodZaPopust() {
        return kodZaPopust;
    }

    public void setKodZaPopust(PopustKodovi kodZaPopust) {
        this.kodZaPopust = kodZaPopust;
    }

    public NacinPlacanja getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }
}
