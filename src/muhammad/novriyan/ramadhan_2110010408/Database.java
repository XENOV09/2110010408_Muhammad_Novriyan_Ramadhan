/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammad.novriyan.ramadhan_2110010408;

/**
 *
 * @author Novriyan09
 */
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Mobil> daftarMobil;
    private List<Penyewaan> daftarPenyewaan;

    public Database() {
        daftarMobil = new ArrayList<>();
        daftarPenyewaan = new ArrayList<>();
    }

    // Metode untuk mengelola daftar mobil

    public void tambahMobil(Mobil mobil) {
        daftarMobil.add(mobil);
    }

    public void hapusMobil(Mobil mobil) {
        daftarMobil.remove(mobil);
    }

    public List<Mobil> getDaftarMobil() {
        return daftarMobil;
    }

    // Metode untuk mengelola daftar penyewaan

    public void tambahPenyewaan(Penyewaan penyewaan) {
        daftarPenyewaan.add(penyewaan);
    }

    public void hapusPenyewaan(Penyewaan penyewaan) {
        daftarPenyewaan.remove(penyewaan);
    }

    public List<Penyewaan> getDaftarPenyewaan() {
        return daftarPenyewaan;
    }
}
