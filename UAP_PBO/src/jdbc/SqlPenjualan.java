package jdbc;

import Entity.Penjualan;
import Entity.Produk;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlPenjualan {
    private final Connection CONN;

    public SqlPenjualan() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addPenjualan(Penjualan penjualan){
        String insert = "INSERT INTO penjualan VALUES ('" + penjualan.getListProduk() + "', " + penjualan.getJumlahProduk() + ", " + penjualan.getStok() + ");";
//        System.out.println(insert);
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }
    
    public void dltPenjualan(Penjualan penjualan){
        String delete = "DELETE FROM penjualan WHERE penjualan.listProduk='" + penjualan.getListProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete)>0){
                System.out.println("Berhasil Menghapus Data");
            }else{
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    
    public void updPenjualan(Penjualan penjualan){
        String update = "UPDATE penjualan SET penjualan.listProduk='" + penjualan.getListProduk()+ "' WHERE penjualan.listProduk='" + penjualan.getListProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
            }else{
                System.out.println("Gagal Update Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
        }
    }
    
    public ArrayList<Produk> getProduk(){
        String query = "SELECT * FROM penjualan";
        ArrayList<Produk> penjualan = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Produk temp = new Produk(rs.getString("listProduk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
                penjualan.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(SqlPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return penjualan;
    }
}
