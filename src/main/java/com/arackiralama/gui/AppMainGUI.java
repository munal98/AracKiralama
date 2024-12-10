package com.arackiralama.gui;

import com.arackiralama.services.AraçService;
import com.arackiralama.services.FirmaService;
import com.arackiralama.services.RezervasyonService;
import com.arackiralama.entities.Araç;
import com.arackiralama.entities.Firma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AppMainGUI {
    private JFrame frame;
    private JTextField firmaAdiField;
    private JTextField sehirField;
    private JComboBox<String> aracTipiComboBox;
    private JTable aracTable;
    private AraçService aracService;
    private FirmaService firmaService;
    private RezervasyonService rezervasyonService;

    // Constructor: Servisler burada başlatılacak
    public AppMainGUI(AraçService aracService, FirmaService firmaService, RezervasyonService rezervasyonService) {
        this.aracService = aracService;
        this.firmaService = firmaService;
        this.rezervasyonService = rezervasyonService;

        // Frame oluşturuluyor
        frame = new JFrame("Araç Kiralama Portalı");
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Firma ekleme
        JLabel lblFirmaAdi = new JLabel("Firma Adı:");
        lblFirmaAdi.setBounds(50, 30, 100, 25);
        frame.getContentPane().add(lblFirmaAdi);

        firmaAdiField = new JTextField();
        firmaAdiField.setBounds(150, 30, 200, 25);
        frame.getContentPane().add(firmaAdiField);
        firmaAdiField.setColumns(10);

        JLabel lblSehir = new JLabel("Şehir:");
        lblSehir.setBounds(50, 70, 100, 25);
        frame.getContentPane().add(lblSehir);

        sehirField = new JTextField();
        sehirField.setBounds(150, 70, 200, 25);
        frame.getContentPane().add(sehirField);
        sehirField.setColumns(10);

        JButton btnFirmaEkle = new JButton("Firma Ekle");
        btnFirmaEkle.setBounds(150, 110, 100, 30);
        frame.getContentPane().add(btnFirmaEkle);

        // Araç filtreleme
        JLabel lblAraçTipi = new JLabel("Araç Tipi:");
        lblAraçTipi.setBounds(50, 160, 100, 25);
        frame.getContentPane().add(lblAraçTipi);

        aracTipiComboBox = new JComboBox<>(new String[]{"Binek", "Arazi", "Ticari"});
        aracTipiComboBox.setBounds(150, 160, 200, 25);
        frame.getContentPane().add(aracTipiComboBox);

        JButton btnAra = new JButton("Ara");
        btnAra.setBounds(150, 200, 100, 30);
        frame.getContentPane().add(btnAra);

        // Araçları listelemek için tablo
        aracTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(aracTable);
        scrollPane.setBounds(50, 240, 500, 100);
        frame.getContentPane().add(scrollPane);

        // Rezervasyon yapma butonu
        JButton btnRezervasyonYap = new JButton("Rezervasyon Yap");
        btnRezervasyonYap.setBounds(150, 360, 150, 30);
        frame.getContentPane().add(btnRezervasyonYap);

        // Firma ekleme işlemi
        btnFirmaEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firmaAdi = firmaAdiField.getText();
                String sehir = sehirField.getText();

                if (firmaAdi.isEmpty() || sehir.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Firma adı ve şehir girilmelidir.");
                    return;
                }

                Firma firma = new Firma(firmaAdi, sehir);
                firmaService.addFirma(firma);  // Firma ekleme servis çağrısı
                JOptionPane.showMessageDialog(frame, "Firma başarıyla eklendi!");
            }
        });

        // Araçları listeleme işlemi
        btnAra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String aracTipi = (String) aracTipiComboBox.getSelectedItem();
                List<Araç> araclar = aracService.getAraçlarByTip(aracTipi); // Araçları filtrele
                updateAraçTable(araclar); // Tabloyu güncelle
            }
        });

        // Rezervasyon yapma işlemi
        btnRezervasyonYap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = aracTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Lütfen bir araç seçin.");
                    return;
                }

                int aracId = (int) aracTable.getValueAt(selectedRow, 0); // Araç ID
                boolean success = rezervasyonService.rezervasyonYap(aracId);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Rezervasyon başarıyla yapıldı!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Rezervasyon sırasında bir hata oluştu.");
                }
            }
        });
    }

    // Araçları JTable'ye yükleme
    private void updateAraçTable(List<Araç> araclar) {
        // Tablo başlıkları
        String[] columnNames = {"ID", "Araç Tipi", "Fiyat", "Başlangıç Tarihi", "Bitiş Tarihi"};
        
        // Araçların verilerini tabloya eklemek için
        Object[][] data = new Object[araclar.size()][5];
        
        for (int i = 0; i < araclar.size(); i++) {
            Araç arac = araclar.get(i);
            data[i][0] = arac.getAracID();  // Araç ID
            data[i][1] = arac.getAracTipi();  // Araç tipi
            data[i][2] = arac.getGunlukFiyat();  // Günlük fiyat
            data[i][3] = arac.getTarihAraligiBaslangic();  // Başlangıç tarihi
            data[i][4] = arac.getTarihAraligiBitis();  // Bitiş tarihi
        }
        
        // Tabloyu güncelleme
        aracTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Servislerin başlatılması
        AraçService aracService = new AraçService();
        FirmaService firmaService = new FirmaService();
        RezervasyonService rezervasyonService = new RezervasyonService();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMainGUI window = new AppMainGUI(aracService, firmaService, rezervasyonService);
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
