/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan8;

import java.util.Scanner;

/**
 *
 * @author Chandra
 */
public class Toko {
    private String namaToko;
    private String noTelepon;
    private String alamatToko;

    public Toko(String namaToko, String noTelepon, String alamatToko) {
        this.namaToko = namaToko;
        this.noTelepon = noTelepon;
        this.alamatToko = alamatToko;
    }

    // Getter dan Setter untuk semua atribut
    public String getNamaToko() { return namaToko; }
    public void setNamaToko(String namaToko) { this.namaToko = namaToko; }
    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }
    public String getAlamatToko() { return alamatToko; }
    public void setAlamatToko(String alamatToko) { this.alamatToko = alamatToko; }


    @Override
    public String toString() {
        return "Toko{" +
                "namaToko='" + namaToko + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                ", alamatToko='" + alamatToko + '\'' +
                '}';
    }
}

class AplikasiToko {
    private Toko[] daftarToko;
    private int jumlahToko;
    private Scanner input;

    public AplikasiToko() {
        daftarToko = new Toko[100]; // Batas maksimal toko yang bisa disimpan
        jumlahToko = 0;
        input = new Scanner(System.in);
    }

    public void menuAplikasi() {
        int pilihan;
        do {
            System.out.println("\nMenu Aplikasi Toko");
            System.out.println("1. Tambah Toko");
            System.out.println("2. Tampilkan Toko");
            System.out.println("3. Ubah Data Toko");
            System.out.println("4. Hapus Toko");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: tambahToko(); break;
                case 2: tampilkanToko(); break;
                case 3: ubahToko(); break;
                case 4: hapusToko(); break;
                case 0: System.out.println("Keluar dari aplikasi."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        input.close();
    }

    private void tambahToko() {
        System.out.print("Nama Toko: ");
        String nama = input.nextLine();
        System.out.print("No Telepon: ");
        String telepon = input.nextLine();
        System.out.print("Alamat Toko: ");
        String alamat = input.nextLine();

        daftarToko[jumlahToko] = new Toko(nama, telepon, alamat);
        jumlahToko++;
        System.out.println("Toko berhasil ditambahkan.");
    }

    private void tampilkanToko() {
        if (jumlahToko == 0) {
            System.out.println("Belum ada data toko.");
            return;
        }
        System.out.println("\nDaftar Toko:");
        for (int i = 0; i < jumlahToko; i++) {
            System.out.println((i + 1) + ". " + daftarToko[i]);
        }
    }

    private void ubahToko() {
        tampilkanToko();
        System.out.print("Pilih nomor toko yang akan diubah (1-" + jumlahToko + "): ");
        int index = input.nextInt();
        input.nextLine(); // Consume newline

        if (index >= 1 && index <= jumlahToko) {
            System.out.print("Nama Toko baru: ");
            daftarToko[index - 1].setNamaToko(input.nextLine());
            System.out.print("No Telepon baru: ");
            daftarToko[index - 1].setNoTelepon(input.nextLine());
            System.out.print("Alamat Toko baru: ");
            daftarToko[index - 1].setAlamatToko(input.nextLine());
            System.out.println("Data toko berhasil diubah.");
        } else {
            System.out.println("Nomor toko tidak valid.");
        }
    }

    private void hapusToko() {
        tampilkanToko();
        System.out.print("Pilih nomor toko yang akan dihapus (1-" + jumlahToko + "): ");
        int index = input.nextInt();

        if (index >= 1 && index <= jumlahToko) {
            for (int i = index - 1; i < jumlahToko - 1; i++) {
                daftarToko[i] = daftarToko[i + 1];
            }
            jumlahToko--;
            System.out.println("Toko berhasil dihapus.");
        } else {
            System.out.println("Nomor toko tidak valid.");
        }
    }
}
    
