package com.arackiralama.services;

import com.arackiralama.entities.Firma;
import java.util.List;
import java.util.ArrayList;

public class FirmaService {
    private List<Firma> firmaListesi = new ArrayList<>();

    public void addFirma(Firma firma) {
        firmaListesi.add(firma);
    }

    public List<Firma> getAllFirmalar() {
        return firmaListesi;
    }
}
