package Entity;

public interface ProductCounter {
    double TAX = 0;

    public double getTAX();

    public void setTAX(double TAX);
    
    public void hitungJumlahProduk();
    public void hitungHargaProduk();
}
