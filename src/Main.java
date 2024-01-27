import Controller.AdminController;
import Controller.ControllerBooking;
import Controller.ControllerKamar;
import Model.AdminModel;
import Model.ModelBooking;
import Model.ModelKamar;
import View.LoginGUI;
import View.Menu;
import View.MenuAdmin;
import View.MenuCustomer;

public class Main {
    public static void main(String[] args) {
        ModelKamar modelKamar = new ModelKamar();
        ControllerKamar controllerKamar = new ControllerKamar(modelKamar);

        AdminModel adminModel = new AdminModel();
        AdminController adminController = new AdminController();

        ModelBooking modelBooking = new ModelBooking(modelKamar);
        ControllerBooking controllerBooking = new ControllerBooking(modelBooking, modelKamar);

        MenuAdmin menuAdmin = new MenuAdmin(adminController, controllerKamar, controllerBooking);
        MenuCustomer viewCustomer = new MenuCustomer(controllerBooking, controllerKamar);

   //     LoginGUI loginGUI = new LoginGUI();
//        Menu menu1= new Menu(menuAdmin, viewCustomer, loginGUI);
        Menu menu1= new Menu(menuAdmin, viewCustomer);
        menu1.menu();
    }
}