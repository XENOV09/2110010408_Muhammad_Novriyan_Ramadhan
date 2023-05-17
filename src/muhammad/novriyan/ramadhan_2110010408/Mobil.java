/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammad.novriyan.ramadhan_2110010408;

/**
 *
 * @author Novriyan09
 */

public class Mobil {
    private String merek;
    private int tahunProduksi;
    private String nomorPlat;
    private boolean tersedia;

    public Mobil(String merek, int tahunProduksi, String nomorPlat) {
        this.merek = merek;
        this.tahunProduksi = tahunProduksi;
        this.nomorPlat = nomorPlat;
        this.tersedia = true;
    }

    // Getter dan setter untuk atribut mobil

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    Object getNomorPlat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getMerek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

