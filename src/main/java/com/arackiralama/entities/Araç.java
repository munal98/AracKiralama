package com.arackiralama.entities;

import java.util.Date;

public class Araç {
    private int aracID; // Araç ID'si
    private int firmaID; // Firma ID'si
    private String aracTipi; // Araç tipi (Binek, Ticari vb.)
    private double gunlukFiyat; // Günlük fiyat
    private Date tarihAraligiBaslangic; // Müsaitlik başlangıcı
    private Date tarihAraligiBitis; // Müsaitlik bitişi

    // Araç yapıcı metodu
    public Araç(int aracID, int firmaID, String aracTipi, double gunlukFiyat, Date tarihAraligiBaslangic, Date tarihAraligiBitis) {
        this.aracID = aracID;
        this.firmaID = firmaID;
        this.aracTipi = aracTipi;
        this.gunlukFiyat = gunlukFiyat;
        this.tarihAraligiBaslangic = tarihAraligiBaslangic;
        this.tarihAraligiBitis = tarihAraligiBitis;
    }

    // Getter ve Setter metodları
    public int getAracID() {
        return aracID;
    }

    public void setAracID(int aracID) {
        this.aracID = aracID;
    }

    public int getFirmaID() {
        return firmaID;
    }

    public void setFirmaID(int firmaID) {
        this.firmaID = firmaID;
    }

    public String getAracTipi() {
        return aracTipi;
    }

    public void setAracTipi(String aracTipi) {
        this.aracTipi = aracTipi;
    }

    public double getGunlukFiyat() {
        return gunlukFiyat;
    }

    public void setGunlukFiyat(double gunlukFiyat) {
        this.gunlukFiyat = gunlukFiyat;
    }

    public Date getTarihAraligiBaslangic() {
        return tarihAraligiBaslangic;
    }

    public void setTarihAraligiBaslangic(Date tarihAraligiBaslangic) {
        this.tarihAraligiBaslangic = tarihAraligiBaslangic;
    }

    public Date getTarihAraligiBitis() {
        return tarihAraligiBitis;
    }

    public void setTarihAraligiBitis(Date tarihAraligiBitis) {
        this.tarihAraligiBitis = tarihAraligiBitis;
    }

    // Müsaitlik durumu kontrolü
    public boolean isMüsait() {
        Date currentDate = new Date();
        return currentDate.after(tarihAraligiBaslangic) && currentDate.before(tarihAraligiBitis);
    }
}
