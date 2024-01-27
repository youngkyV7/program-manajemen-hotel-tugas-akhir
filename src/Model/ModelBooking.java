package Model;

import ModelJSON.ModelJSON;
import NodeData.NodeDataBooking;
import NodeData.NodeDataKamar;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ModelBooking {
    private ArrayList<NodeDataBooking> booking ;
    private ModelJSON modelJSONBooking ;
    private ModelKamar modelKamar ;
    public ModelBooking(ModelKamar modelKamar) {
        this.booking = new ArrayList<>();
        this.modelJSONBooking = new ModelJSON("src/Database/booking.json");
        this.modelKamar = modelKamar;
        loadBooking();
    }
    public ArrayList<NodeDataBooking> allArrayBooking(){
        return booking;
    }
    private void loadBooking() {
        booking = modelJSONBooking.readFromFile(new TypeToken<ArrayList<NodeDataBooking>>() {}.getType());
        for (NodeDataBooking bookingItem : booking) {
            setKamarForBooking(bookingItem);
        }
    }
    public int getLastCode() {
        int last = booking.size() - 1;
        return (last >= 0) ? booking.get(last).getBookingId() : 0;
    }
    private void setKamarForBooking(NodeDataBooking bookingItem) {
        ArrayList<NodeDataKamar> kamarBooking = new ArrayList<>();
        for (NodeDataKamar kamar : bookingItem.getKamar()) {
            NodeDataKamar kamarData = modelKamar.getKamar(kamar.getKode());
            if (kamarData != null) {
                kamarBooking.add(kamarData);
            }
        }
        bookingItem.setKamar(kamarBooking);
    }

    public void booking(String nama, String noHp, int jumlahKamar,int hargaTotal, int harga, ArrayList<NodeDataKamar> kodeKamar) {
        boolean allRoomsAvailable = true;
        for (NodeDataKamar kamar : kodeKamar) {
            if (!modelKamar.isKamarAvailable(kamar.getKode())) {
                allRoomsAvailable = false;
                break;
            }
        }
        if (allRoomsAvailable) {
            int idBooking = getLastCode() + 1;
            NodeDataBooking newBooking = new NodeDataBooking(nama, noHp, jumlahKamar, idBooking, hargaTotal, kodeKamar);
            booking.add(newBooking);
            setKamarForBooking(newBooking);

            for (NodeDataKamar kamar : kodeKamar) {
                modelKamar.update(kamar.getKode(), true);
            }
            modelJSONBooking.writeToFile(booking);
            modelKamar.commit();
        } else {
            System.out.println("Satu atau lebih kamar tidak tersedia untuk pemesanan.");
        }
    }

    public void commit() {
        modelJSONBooking.writeToFile(booking);
    }

    public boolean deleteBooking(int idBooking) {
        NodeDataBooking bookingItem = getBooking(idBooking);
        if (bookingItem != null) {
            for (NodeDataKamar kamar : bookingItem.getKamar()) {
                modelKamar.updateStatusKamar(kamar.getKode(), false);
            }

            booking.remove(bookingItem);
            modelJSONBooking.writeToFile(booking);
            modelKamar.commit();
            return true;
        }
        return false;
    }
    public ArrayList<NodeDataKamar> getKamarFromKode(ArrayList<NodeDataKamar> kodeKamar) {
        ArrayList<NodeDataKamar> kamarBooking = new ArrayList<>();
        for (NodeDataKamar kamar : kodeKamar) {
            NodeDataKamar kamarData = modelKamar.getKamar(kamar.getKode());
            if (kamarData != null) {
                kamarBooking.add(kamarData);
            }
        }
        return kamarBooking;
    }

    public NodeDataBooking getBooking(int idBooking) {
        for (NodeDataBooking bookingItem : booking) {
            if (bookingItem.getBookingId() == idBooking) {
                return bookingItem;
            }
        }
        return null;
    }
    public void lihatSemua(){
        if(booking.isEmpty()){
            System.out.println("Belum Ada Data Customer");
        }else{
            System.out.println("Daftar Semua Data Customer");

            for(NodeDataBooking data : booking){
                System.out.println("Nama : " + data.getNama());
                System.out.println("No Hp : " + data.getNoHp());
                System.out.println("------------------------------------------------");

            }
        }
    }
}
