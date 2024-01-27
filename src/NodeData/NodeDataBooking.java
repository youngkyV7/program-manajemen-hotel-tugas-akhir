package NodeData;

import java.util.ArrayList;

public class NodeDataBooking {
    private String nama;
    private String noHp;
    private int jumlahKamar;
    private int bookingId;
    private int hargaTotal;
    private ArrayList<NodeDataKamar> kamar;

    public NodeDataBooking(String nama, String noHp, int jumlahKamar, int bookingId, int hargaTotal, ArrayList<NodeDataKamar> kamar) {
        this.nama = nama;
        this.noHp = noHp;
        this.jumlahKamar = jumlahKamar;
        this.bookingId = bookingId;
        this.hargaTotal = hargaTotal;
        this.kamar = kamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public int getJumlahKamar() {
        return jumlahKamar;
    }

    public void setJumlahKamar(int jumlahKamar) {
        this.jumlahKamar = jumlahKamar;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public int getBookingId() {
        return bookingId;
    }

    public ArrayList<NodeDataKamar> getKamar() {
        return kamar;
    }

    public void setKamar(ArrayList<NodeDataKamar> kamar) {
        this.kamar = kamar;
    }
}
