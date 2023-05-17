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
import java.util.Scanner;

public class Aplikasi {
    private final Database database;

    public Aplikasi() {
        database = new Database();
    }

    public void tampilkanMenu() {
        System.out.println("=== APLIKASI PENYEWAAN MOBIL ===");
        System.out.println("1. Tampilkan Daftar Mobil");
        System.out.println("2. Tampilkan Daftar Penyewaan");
        System.out.println("3. Sewa Mobil");
        System.out.println("4. Kembalikan Mobil");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");
    }

    public void jalankan() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> tampilkanDaftarMobil();
                case 2 -> tampilkanDaftarPenyewaan();
                case 3 -> sewaMobil();
                case 4 -> kembalikanMobil();
                case 0 -> System.out.println("Terima kasih. Sampai jumpa!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    public void tampilkanDaftarMobil() {
        System.out.println("=== DAFTAR MOBIL ===");
        for (Mobil mobil : database.getDaftarMobil()) {
            System.out.println(mobil.getMerek() + " - " + mobil.getNomorPlat());
        }
        System.out.println();
    }

    public void tampilkanDaftarPenyewaan() {
        System.out.println("=== DAFTAR PENYEWAAN ===");
        for (Penyewaan penyewaan : database.getDaftarPenyewaan()) {
            System.out.println("Penyewa: " + penyewaan.getPenyewa().getNama());
            System.out.println("Mobil: " + penyewaan.getMobil().getMerek() + " - " + penyewaan.getMobil().getNomorPlat());
            System.out.println("Tanggal Mulai: " + penyewaan.getTanggalMulai());
            System.out.println("Tanggal Kembali: " + penyewaan.getTanggalKembali());
            System.out.println("Harga Sewa: " + penyewaan.getHargaSewa());
            System.out.println("Status Pembayaran: " + (penyewaan.isPembayaranSelesai() ? "Sudah Lunas" : "Belum Lunas"));
            System.out.println();
        }
    }

    public void sewaMobil() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Penyewa: ");
        String namaPenyewa = scanner.nextLine();

        System.out.print("Alamat Penyewa: ");
        String alamatPenyewa = scanner.nextLine();

        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();

        System.out.print("Merek Mobil: ");
        String merekMobil = scanner.nextLine();

        System.out.print("Tahun Produksi Mobil: ");
        int tahunProduksi = scanner.nextInt();

        System.out.print("Nomor Plat Mobil: ");
        String nomorPlat = scanner.next();

        System.out.print("Tanggal Mulai");
        LocalDate tanggalMulai = LocalDate.parse(scanner.next());

        System.out.print("Tanggal Kembali (yyyy-MM-dd): ");
        LocalDate tanggalKembali = LocalDate.parse(scanner.next());

        System.out.print("Harga Sewa: ");
        double hargaSewa = scanner.nextDouble();

        // Membuat objek penyewa dan mobil
        Penyewa penyewa = new Penyewa(namaPenyewa, alamatPenyewa, nomorTelepon);
        Mobil mobil = new Mobil(merekMobil, tahunProduksi, nomorPlat);

        // Membuat objek penyewaan
        Penyewaan penyewaan = new Penyewaan(tanggalMulai, tanggalKembali, hargaSewa);
        penyewaan.setPenyewa(penyewa);
        penyewaan.setMobil(mobil);

        // Menambahkan penyewaan ke database
        database.tambahPenyewaan(penyewaan);

        // Mengupdate status ketersediaan mobil
        mobil.setTersedia(false);

        System.out.println("Penyewaan berhasil dilakukan.\n");
    }

    public void kembalikanMobil() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nomor Plat Mobil: ");
        String nomorPlat = scanner.next();

        // Mencari mobil berdasarkan nomor plat
        Mobil mobil = cariMobil(nomorPlat);

        if (mobil != null && !mobil.isTersedia()) {
            // Mengupdate status ketersediaan mobil
            mobil.setTersedia(true);

            System.out.print("Tanggal Kembali (yyyy-MM-dd): ");
            LocalDate tanggalKembali = LocalDate.parse(scanner.next());

            // Mencari penyewaan yang sesuai berdasarkan mobil
            Penyewaan penyewaan = cariPenyewaan(mobil);

            if (penyewaan != null) {
                // Mengupdate tanggal kembali penyewaan
                penyewaan.setTanggalKembali(tanggalKembali);

                System.out.print("Total Pembayaran: ");
                double totalPembayaran = scanner.nextDouble();

                // Mengupdate status pembayaran
                if (totalPembayaran >= penyewaan.getHargaSewa()) {
                    penyewaan.setPembayaranSelesai(true);
                    System.out.println("Mobil telah dikembalikan dan pembayaran selesai.\n");
                } else {
                    System.out.println("Pembayaran kurang. Harap selesaikan pembayaran.\n");
                }
            } else {
                System.out.println("Tidak ditemukan penyewaan untuk mobil ini.\n");
            }
        } else {
            System.out.println("Mobil tidak ditemukan atau sudah tersedia.\n");
        }
    }

    private Mobil cariMobil(String nomorPlat) {
        for (Mobil mobil : database.getDaftarMobil()) {
            if (mobil.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                return mobil;
            }
        }
        return null;
    }

    private Penyewaan cariPenyewaan(Mobil mobil) {
        for (Penyewaan penyewaan : database.getDaftarPenyewaan()) {
            if (penyewaan.getMobil() == mobil) {
                return penyewaan;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Aplikasi aplikasi = new Aplikasi();
        aplikasi.jalankan();
    }
}

