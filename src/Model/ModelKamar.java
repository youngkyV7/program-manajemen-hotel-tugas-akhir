package Model;

import ModelJSON.ModelJSON;
import NodeData.NodeDataKamar;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ModelKamar implements CRUD<NodeDataKamar> {
    private ArrayList<NodeDataKamar> kamars ;
    private ModelJSON<NodeDataKamar> modelJSONKamar ;
    public ModelKamar() {
        kamars = new ArrayList<NodeDataKamar>();
        modelJSONKamar = new ModelJSON<NodeDataKamar>("src/Database/Kamar.json");
        LoadKamar();
    }
    private void LoadKamar(){
        kamars = modelJSONKamar.readFromFile(new TypeToken<ArrayList<NodeDataKamar>>() {}.getType());;
    }
    public void create(NodeDataKamar kamar){
        kamars.add(kamar);
    }
    @Override
    public NodeDataKamar read() {
        return null;
    }
    public boolean isKamarAvailable(int kode) {
        NodeDataKamar kamar = getKamar(kode);
        return kamar != null && !kamar.getStatus();
    }
    public void update(int kodeKamar, boolean status) {
        NodeDataKamar kamar = getKamar(kodeKamar);
        if (kamar != null) {
            kamar.setStatus(status);
        }
    }

    public void commit(){
        modelJSONKamar.writeToFile(kamars);
    }
    public NodeDataKamar getKamar(int kode){
        NodeDataKamar kamar = null;
        for(NodeDataKamar kamar1:kamars){
            if(kamar1.kode == kode){
                return kamar1;
            }
        }
        return kamar;
    }

    public void update(NodeDataKamar updateKamar) {
        NodeDataKamar kamar = getKamar(updateKamar.kode);
        if (kamar != null) {
            kamar.setKode(updateKamar.kode);
            kamar.setKategori(updateKamar.kategori);
            kamar.setharga(updateKamar.harga);
            commit();
        }

    }
    public boolean delete(int kode){
        NodeDataKamar kamar = getKamar(kode);
        if(kamar != null){
            kamars.remove(kamar);
            return true;
        }
        return false;
    }
    public ArrayList<NodeDataKamar> getDaftarkamar(){
        return kamars;
    }
    public void tampilkanKamar(ArrayList<NodeDataKamar> daftarKamar) {
        System.out.println("Daftar Barang:");
        for (NodeDataKamar kamar : daftarKamar) {
            System.out.println(", Kode " + kamar.kode + ", Kategori " + kamar.kategori +", Harga"+kamar.harga +", Status: " + kamar.status);
        }
    }
    public void updateStatusKamar(int kodeKamar, boolean status) {
        NodeDataKamar kamar = getKamar(kodeKamar);
        if (kamar != null) {
            kamar.setStatus(status);
        }
    }
}
