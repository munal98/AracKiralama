package com.arackiralama.entities;

public class Rezervasyon {
    private Araç arac;  // Araç nesnesi
    private String tarih; // Rezervasyon tarihi

    // Yapıcı metod
    public Rezervasyon(Araç arac, String tarih) {
        this.arac = arac;
        this.tarih = tarih; // Tarih, bir rezervasyonla ilişkili olmalı
    }

    // Getter ve Setter metodları
    public Araç getArac() {
        return arac;
    }

    public void setArac(Araç arac) {
        this.arac = arac;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
