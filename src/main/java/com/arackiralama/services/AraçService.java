package com.arackiralama.services;

import com.arackiralama.entities.Araç;
import java.util.List;
import java.util.ArrayList;


public class AraçService {
    // Araç listesi (Veritabanı yerine örnek)
    private List<Araç> aracListesi = new ArrayList<>();

    // Araç ekleme
    public void addAraç(Araç araç) {
        aracListesi.add(araç);
    }

    // Araçları araç tipiyle filtreleme
    public List<Araç> getAraçlarByTip(String aracTipi) {
        List<Araç> filteredList = new ArrayList<>();
        for (Araç arac : aracListesi) {
            if (arac.getAracTipi().equalsIgnoreCase(aracTipi)) {
                filteredList.add(arac);
            }
        }
        return filteredList;
    }

    // Tüm araçları listeleme
    public List<Araç> getAllAraçlar() {
        return aracListesi;
    }
}
