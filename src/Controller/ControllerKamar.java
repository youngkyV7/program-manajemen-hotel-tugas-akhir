package Controller;

import Model.ModelKamar;
import NodeData.NodeDataKamar;

import java.util.ArrayList;

public class ControllerKamar {
    public ModelKamar modelKamar;

    public ControllerKamar(ModelKamar modelKamar) {
        this.modelKamar = modelKamar;
    }
    public ArrayList<NodeDataKamar> getDaftarkamar() {
        return modelKamar.getDaftarkamar();
    }
    public NodeDataKamar insertKamar(int kode, String kategori, int hargatotal) {
        modelKamar.create(new NodeDataKamar(kode, kategori, hargatotal));
        modelKamar.commit();
        return null;
    }
    public NodeDataKamar tampilkanDaftarkamar() {
        modelKamar.tampilkanKamar(getDaftarkamar());
        return null;
    }
    public boolean updateKamar(int kodeKamar, int newKode, String newKategori, int newHarga) {
        NodeDataKamar existingKamar = modelKamar.getKamar(kodeKamar);
        if (existingKamar != null) {
            existingKamar.kode = newKode;
            existingKamar.kategori = newKategori;
            existingKamar.harga = newHarga;
            modelKamar.update(existingKamar);
            modelKamar.commit();
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteKamar(int kode){
        modelKamar.delete(kode);
        modelKamar.commit();
        return true;
    }
}
