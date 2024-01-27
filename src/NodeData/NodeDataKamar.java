package NodeData;

public class NodeDataKamar {
    public int kode;
    public String kategori;
    public int harga;
    public boolean status;

    public NodeDataKamar( int kode, String kategori, int harga) {
        this.kode = kode;
        this.kategori = kategori;
        this.status = false;
        this.harga = harga;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setharga(int harga){
        this.harga = harga;
    }

    public int getKode() {
        return kode;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
