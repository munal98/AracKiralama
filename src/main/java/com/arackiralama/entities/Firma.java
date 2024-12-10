package com.arackiralama.entities;

public class Firma {
    private String firmaAdi;
    private String sehir;

    // Constructor
    public Firma(String firmaAdi, String sehir) {
        this.firmaAdi = firmaAdi;
        this.sehir = sehir;
    }

    // Getters ve Setters
    public String getFirmaAdi() { return firmaAdi; }
    public String getSehir() { return sehir; }

    public void setFirmaAdi(String firmaAdi) { this.firmaAdi = firmaAdi; }
    public void setSehir(String sehir) { this.sehir = sehir; }
}
