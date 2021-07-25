package com.pristupni_zadatak.miniwebshop.form;

import java.time.LocalDate;

public class NarudzbaForm {

    private LocalDate datum;

    private double ukupnaCijenaBezP;

    private double ukupnaCijenaSP;

    private Long kodZaPopustId;

    private Long nacinPlacanjaId;

    private String brojKartice;

    private String email;

    private Long brojMobitela;

    private String adresaDostave;

    private String napomena;

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
}
