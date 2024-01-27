package Controller;

import Model.AdminModel;
import NodeData.AdminNode;

import java.util.ArrayList;

public class AdminController {
    public ArrayList<AdminNode> allArrayAdminNode(){
        return AdminModel.allArrayAdminNode();
    }
    public boolean loginAdmin(String nama, String password){
        return AdminModel.loginAdmin(nama, password);
    }
}
