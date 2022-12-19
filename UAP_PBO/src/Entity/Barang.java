package Entity;

import java.util.ArrayList;

public class Barang extends Produk {
    private String barcode;
    private String expired;
    private ArrayList<Kategori> kategori;

    public Barang(String nama_produk, double harga, int jumlah, double diskon, String barcode, String expired) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
    }
    
    public Barang(String nama_produk, double harga, int jumlah, double diskon){
        super(nama_produk, harga = 0, jumlah = 0, diskon = 0);  
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
    
    
    public void isExpired(){
        
    }
    public void addKategori(){
        
    }
}
