package jdbc;

import Entity.Barang;
import Entity.Makanan;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlBarang {
    private final Connection CONN;
    public boolean status;

    public SqlBarang() {
        this.CONN = DBHelper.getConnection();
    }
    
    //addMakanan
    public void addBarangSQL(Barang brg){
        String insert = "INSERT INTO `barang`(`nama_produk`, `harga`, `jumlah`, `diskon`, `barcode_barang`, `expired`) VALUES ('"
                + brg.getNama_produk() + "', '" + brg.getHarga() + "', '" 
                + brg.getJumlah() + "', '" + brg.getDiskon()+ "', '" 
                + brg.getBarcode()+ "', '" + brg.getExpired() + "');";
//        System.out.println(insert);
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("Berhasil Memasukkan Data");
                status = true;
            }else{
                System.out.println("Gagal Memasukkan Data");
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
            status = false;
        }
    }
    
    public void dltMakananSQL(Barang barang){
        String delete = "DELETE FROM barang WHERE barang.nama_produk='" + barang.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete)>0){
                System.out.println("Berhasil Menghapus Data");
                status = true;
            }else{
                System.out.println("Gagal Menghapus Data");
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
            status = false;
        }
    }
    public void updHargaMakanan(Barang barang){
        String update = "UPDATE barang SET barang.harga='" + barang.getHarga()+ "' WHERE barang.nama_produk='" + barang.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
            }else{
                System.out.println("Gagal Update Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
        }
    }
    
    
    public ArrayList<Makanan> getMakanan(){
        String query = "SELECT * FROM barang";
        ArrayList<Makanan> barang = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Makanan temp = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("daya_tahan"));
                barang.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return barang;
    }
}
