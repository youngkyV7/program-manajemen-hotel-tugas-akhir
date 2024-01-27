package View;

import Controller.AdminController;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in) ;
    AdminController adminController = new AdminController();
    MenuAdmin viewAdmin;
    MenuCustomer viewCustomer;
//    LoginGUI loginGUI;
//    public Menu(MenuAdmin viewAdmin, MenuCustomer viewCostumer, LoginGUI loginGUI) {
    public Menu(MenuAdmin viewAdmin, MenuCustomer viewCostumer) {
        this.viewAdmin = viewAdmin;
        this.viewCustomer = viewCostumer;
        //this.loginGUI = loginGUI ;
    }
    public void menu(){
        int pilihan;
        do{
            System.out.println("------HOTEL------");
            System.out.println("1. Login Menu Admin");
            System.out.println("2. Menu Customer");
            System.out.println("0. Keluar ");
            System.out.print("Masukkan pilihan : ");
            pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    viewAdmin.login();
                    //loginGUI.LoginGUI();
                    break;
                case 2:
                    viewCustomer.menuCustomer();
                    break;
                case 0:
                    System.out.println("Keluar dari program");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while (pilihan != 0);
    }
}
