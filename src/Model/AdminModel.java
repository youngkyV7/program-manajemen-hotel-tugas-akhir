package Model;

import NodeData.AdminNode;

import java.util.ArrayList;

public class AdminModel {
    private static ArrayList<AdminNode> arrayAdminNode = new ArrayList<>();
    public static ArrayList<AdminNode> allArrayAdminNode() {
        return arrayAdminNode;
    }
    public static void dataAdmin(){
        arrayAdminNode.add(new AdminNode("Yongky", 030104, "yongky08"));
    }
    public static boolean loginAdmin(String nama, String password){
        for(AdminNode objAdmin : arrayAdminNode){
            if(objAdmin.getNama().equals(nama) && objAdmin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

