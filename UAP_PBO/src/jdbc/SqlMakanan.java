package jdbc;

import Entity.Makanan;
import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlMakanan {
    private final Connection CONN;
    public boolean status;

    public SqlMakanan() {
        this.CONN = DBHelper.getConnection();
    }
    //addMakanan
    public void addMakananSQL(Makanan mkn){
        String insert = "INSERT INTO `makanan`(`nama_produk`, `harga`, `jumlah`, `diskon`, `daya_tahan`) VALUES ('" 
                + mkn.getNama_produk() + "', '" + mkn.getHarga() + "', '" 
                + mkn.getJumlah()+ "','" + mkn.getDiskon() + "', '" 
                + mkn.getDaya_tahan() + "');";
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
    
    public void dltMakananSQL(Makanan makanan){
        String delete = "DELETE FROM makanan WHERE makanan.nama_produk='" + makanan.getNama_produk() + "';";
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
            status = true;
        }
    }
    public void updMakananSQL(Makanan makanan){
        String update = "UPDATE `makanan` SET `harga`=" + makanan.getHarga() + 
                ", `jumlah`=" + makanan.getJumlah() + 
                ", `diskon`=" + makanan.getDiskon() + 
                ", `daya_tahan`=" + makanan.getDaya_tahan() +
                " WHERE `nama_produk`='" + makanan.getNama_produk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(update)>0){
                System.out.println("Berhasil Update Data");
                status = true;
            }else{
                System.out.println("Gagal Update Data");
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Update Data");
            status = false;
        }
    }
    
    public ArrayList<Makanan> getMakanan(){
        String query = "SELECT * FROM makanan";
        ArrayList<Makanan> makanan = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Makanan temp = new Makanan(rs.getString("nama_produk"), rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("daya_tahan"));
                makanan.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(SqlMakanan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Berhasil Mengambil Data");
        }
        return makanan;
    }
}
