package com.arackiralama.entities;

public class Kullanici {
    private int kullaniciID;
    private String adSoyad;
    private String email;
    private String telefon;

    public Kullanici(int kullaniciID, String adSoyad, String email, String telefon) {
        this.kullaniciID = kullaniciID;
        this.adSoyad = adSoyad;
        this.email = email;
        this.telefon = telefon;
    }

    // Getter ve Setter metotları
    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
