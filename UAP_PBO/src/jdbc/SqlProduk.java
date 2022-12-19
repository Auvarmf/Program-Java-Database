package jdbc;

import Entity.Produk;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlProduk {
    private final Connection CONN;

    public SqlProduk() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addProduct(Produk produk){
        String insert = "INSERT INTO produk VALUES ('" + produk.getNama_produk() + "', " + produk.getHarga() + ", " + produk.getJumlah() + ", " + produk.getDiskon() + ");";
//        System.out.println(insert);
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProduk.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data");
        }
    }
    
    public void dltProduk(Produk produk){
        String delete = "DELETE FROM produk WHERE produk.nama_produk='" + produk.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete)>0){
                System.out.println("Berhasil Menghapus Data");
            }else{
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProduk.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    public void updProduk(Produk produk){
        String update = "UPDATE produk SET produk.harga='" + produk.getHarga()+ "' WHERE produk.nama_produk='" + produk.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
            }else{
                System.out.println("Gagal Update Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProduk.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
        }
    }
    
    public ArrayList<Produk> getProduk(){
        String query = "SELECT * FROM produk";
        ArrayList<Produk> produk = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Produk temp = new Produk(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
                produk.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(SqlProduk.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return produk;
    }
}
