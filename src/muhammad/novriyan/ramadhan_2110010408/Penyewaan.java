/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammad.novriyan.ramadhan_2110010408;

/**
 *
 * @author Novriyan09
 */
import java.time.LocalDate;

public class Penyewaan {
    private LocalDate tanggalMulai;
    private LocalDate tanggalKembali;
    private double hargaSewa;
    private boolean pembayaranSelesai;

    public Penyewaan(LocalDate tanggalMulai, LocalDate tanggalKembali, double hargaSewa) {
        this.tanggalMulai = tanggalMulai;
        this.tanggalKembali = tanggalKembali;
        this.hargaSewa = hargaSewa;
        this.pembayaranSelesai = false;
    }

    // Getter dan setter untuk atribut penyewaan

    public boolean isPembayaranSelesai() {
        return pembayaranSelesai;
    }

    public void setPembayaranSelesai(boolean pembayaranSelesai) {
        this.pembayaranSelesai = pembayaranSelesai;
    }

    Mobil getMobil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setTanggalKembali(LocalDate tanggalKembali) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double getHargaSewa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setMobil(Mobil mobil) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setPenyewa(Penyewa penyewa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getPenyewa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getTanggalMulai() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getTanggalKembali() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
