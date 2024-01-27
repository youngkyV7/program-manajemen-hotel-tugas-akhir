package Controller;

import Model.ModelBooking;
import Model.ModelKamar;
import NodeData.NodeDataBooking;
import NodeData.NodeDataKamar;

import java.util.ArrayList;

public class ControllerBooking {
    public ModelBooking modelBooking;
    public ModelKamar modelKamar;
    ArrayList<NodeDataBooking> keluarList;

    public ControllerBooking(ModelBooking modelBooking, ModelKamar modelKamar) {
        this.modelBooking = modelBooking;
        this.modelKamar = modelKamar;
    }
    public void booking(String nama, String noHp, int jumlahKamar, int hargaTotal, int harga, ArrayList<NodeDataKamar> kodeKamar) {
        ArrayList<NodeDataKamar> kamarbooking = modelBooking.getKamarFromKode(kodeKamar);
        modelBooking.getLastCode();
        modelBooking.booking(nama, noHp, jumlahKamar, hargaTotal, harga, kodeKamar);
        modelBooking.commit();
    }
    public boolean deleteBooking(int idBooking) {
        boolean deleted = modelBooking.deleteBooking(idBooking);
        if (deleted) {
            modelBooking.commit();
        }
        return deleted;
    }
    public ArrayList<NodeDataBooking> data(){
        modelBooking.lihatSemua();
        ArrayList<NodeDataBooking> keluar = modelBooking.allArrayBooking();
        return keluar;
    }
}
