package com.pristupni_zadatak.miniwebshop.dto;

public class NarudzbaProizvodiDto {

    private Long id;

    private Long narudzbaId;

    private Long proizvodId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
