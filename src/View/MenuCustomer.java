package View;

import Controller.ControllerBooking;
import Controller.ControllerKamar;
import NodeData.NodeDataKamar;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCustomer {
    private final Scanner scanner = new Scanner(System.in);
    ControllerBooking controllerBooking;
    ControllerKamar controllerKamar;

    public MenuCustomer(ControllerBooking controllerBooking, ControllerKamar controllerKamar) {
        this.controllerBooking = controllerBooking;
        this.controllerKamar = controllerKamar;
    }

    public void menuCustomer() {
        int pilihan;
        do {
            System.out.println("------HOTEL------");
            System.out.println("1. Booking Kamar");
            System.out.println("2. Batal Booking");
            System.out.println("3. Lihat Kamar");
            System.out.println("0. Keluar ");
            System.out.print("Masukkan pilihan : ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    for (NodeDataKamar kamar : controllerKamar.getDaftarkamar()) {
                        if (!kamar.status) {
                            System.out.println("===========================");
                            System.out.println("Id kamar: " + kamar.kode);
                            System.out.println("Kategori: " + kamar.kategori);
                            System.out.println("Harga: " + kamar.harga);
                        }
                    }
                    System.out.println("===========================");
                    System.out.print("Masukkan nama: ");
                    String namaBooking = scanner.next();
                    System.out.print("Masukkan nomor HP: ");
                    String noHpBooking = scanner.next();
                    System.out.print("Masukkan jumlah kamar: ");
                    int jumlahKamarBooking = scanner.nextInt();

                    int harga = 0;
                    ArrayList<NodeDataKamar> kodeKamarBooking = new ArrayList<>();

                    for (int i = 0; i < jumlahKamarBooking; i++) {
                        System.out.println("Pilih kategori kamar ke-" + (i + 1) + ": ");
                        System.out.println("1. VIP");
                        System.out.println("2. Biasa");
                        System.out.print("Masukkan pilihan kategori: ");
                        int pilihKategori = scanner.nextInt();

                        if (pilihKategori == 1) {
                            System.out.println("Daftar Kamar VIP:");
                            for (NodeDataKamar kamar : controllerKamar.getDaftarkamar()) {
                                if (!kamar.status && kamar.kategori.equalsIgnoreCase("VIP")) {
                                    System.out.println("===========================");
                                    System.out.println("Id kamar: " + kamar.kode);
                                    System.out.println("Kategori: " + kamar.kategori);
                                    System.out.println("Harga: " + kamar.harga);
                                }
                            }
                        } else if (pilihKategori == 2) {
                            System.out.println("Daftar Kamar Biasa:");
                            for (NodeDataKamar kamar : controllerKamar.getDaftarkamar()) {
                                if (!kamar.status && kamar.kategori.equalsIgnoreCase("Biasa")) {
                                    System.out.println("===========================");
                                    System.out.println("Id kamar: " + kamar.kode);
                                    System.out.println("Kategori: " + kamar.kategori);
                                    System.out.println("Harga: " + kamar.harga);
                                }
                            }
                        } else {
                            System.out.println("Pilihan kategori tidak valid");
                            i--;
                            continue;
                        }
                        System.out.print("Masukkan kode kamar ke-" + (i + 1) + ": ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        NodeDataKamar Kamar = controllerKamar.modelKamar.getKamar(id);
                        kodeKamarBooking.add(Kamar);
                        harga += Kamar.harga;
                    }
                    int hargaTotal = harga;
                    controllerBooking.booking(namaBooking, noHpBooking, jumlahKamarBooking, hargaTotal, harga, kodeKamarBooking);
                    System.out.println("Pemesanan berhasil ditambahkan");
                    System.out.println("Total Harga: " + hargaTotal);
                    break;
                case 2:
                    System.out.print("Masukkan ID Booking yang akan dibatalkan: ");
                    int idBookingToDelete = scanner.nextInt();
                    boolean deleteBooking = controllerBooking.deleteBooking(idBookingToDelete);
                    if (deleteBooking) {
                        System.out.println("Booking berhasil dibatalkan");
                    } else {
                        System.out.println("Booking tidak ditemukan atau gagal membatalkan");
                    }
                    break;
                case 3:
                    controllerKamar.tampilkanDaftarkamar();
                    break;
                case 0:
                    System.out.println("keluar dari menu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }
}
