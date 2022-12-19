package Entity;

public class Makanan extends Produk {
    private int id;
    private String daya_tahan;

    public Makanan(String nama_produk, double harga, int jumlah, double diskon, String daya_tahan) {
        super(nama_produk, harga, jumlah, diskon);
        this.daya_tahan = daya_tahan;
    }
    public Makanan(String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga = 0, jumlah = 0, diskon = 0);
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaya_tahan() {
        return daya_tahan;
    }

    public void setDaya_tahan(String daya_tahan) {
        this.daya_tahan = daya_tahan;
    }
    
    
    public void isSpoiled(){
        
    }
}
