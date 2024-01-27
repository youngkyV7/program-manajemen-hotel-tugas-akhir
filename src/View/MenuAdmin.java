package View;

import Controller.AdminController;
import Controller.ControllerBooking;
import Controller.ControllerKamar;
import Model.AdminModel;

import java.util.Scanner;

public class MenuAdmin {
    static Scanner input = new Scanner(System.in) ;
    static ControllerKamar controllerKamar ;
    static ControllerBooking controllerBooking ;
    AdminController adminController ;
    public MenuAdmin(AdminController adminController, ControllerKamar controllerKamar, ControllerBooking controllerBooking) {
        this.controllerKamar = controllerKamar ;
        this.adminController = adminController ;
        this.controllerBooking = controllerBooking ;
    }
    public void login() {
            try {
                AdminModel.dataAdmin();
                boolean status = false;
                System.out.print("Masukkan Username Admin = ");
                String nama = input.nextLine();
                System.out.print("Masukkan Password       = ");
                String password = input.nextLine();
                status = adminController.loginAdmin(nama, password);
                if (status) {
                    System.out.println("Berhasil Login");
                    menuAdmin();
                } else {
                    System.out.println("Username Atau Password Salah");
                }

            } catch (Exception e) {
                input.nextLine();
            }
    }
    public static void menuAdmin() {
        int pilihan;
        do{
            System.out.println("------HOTEL------");
            System.out.println("1. Insert Kamar ");
            System.out.println("2. Lihat Kamar ");
            System.out.println("3. Update Kamar ");
            System.out.println("4. Delete Kamar ");
            System.out.println("5. Check Out Kamar Customer");
            System.out.println("0. Keluar ");
            System.out.print("Masukkan pilihan : ");
            pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    System.out.print("kode: ");
                    int kode = input.nextInt();
                    System.out.print("Kategori: ");
                    String kategori = input.next();
                    System.out.print("harga: ");
                    int harga = input.nextInt();
                    controllerKamar.insertKamar(kode, kategori, harga);
                    System.out.println("Kamar Berhasil Ditambahkan");
                    break;
                case 2:
                    controllerKamar.tampilkanDaftarkamar();
                    break;
                case 3:
                    System.out.print("Masukkan kode kamar yang akan diupdate: ");
                    int kodeUpdate = input.nextInt();
                    System.out.print("Masukkan kode baru: ");
                    int newKode = input.nextInt();
                    System.out.print("Masukkan kategori baru: ");
                    String newKategori = input.next();
                    System.out.print("Masukkan Harga: ");
                    int newHarga = input.nextInt();

                    boolean updateSuccess = controllerKamar.updateKamar(kodeUpdate, newKode, newKategori, newHarga);
                    if (updateSuccess) {
                        System.out.println("Kamar Berhasil Diupdate");
                    } else {
                        System.out.println("Update Kamar Gagal. Kode kamar tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan Kode Yang Akan Dihapus : ");
                    pilihan=input.nextInt();
                    boolean delete = controllerKamar.deleteKamar(pilihan);
                    if (delete){
                        System.out.println("Delete Kamar Berhasil");
                    }else{
                        System.out.println("Delete Kamar Gagal");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan ID yang akan di Check Out: ");
                    int idToDelete = input.nextInt();
                    boolean deleteBooking = controllerBooking.deleteBooking(idToDelete);
                    if (deleteBooking) {
                        System.out.println("Check Out berhasil");
                    } else {
                        System.out.println("Check Out Gagal");
                    }
                    break;
                case 6:
                    controllerBooking.data();
                    break;
//                case 6:
//                    System.out.println("Data Check In Customer");
//                    if (controllerBooking.modelBooking!= null) {
//                        for (NodeDataBooking controllerBooking :
//                             ) {
//
//                        }
//                }
//                    break;
                case 0:
                    System.out.println("keluar dari menu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while (pilihan != 0);
    }
}
