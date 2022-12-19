package uap_pbo;

import Entity.Barang;
import Entity.Makanan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc.SqlBarang;
import jdbc.SqlMakanan;

public class ListBarangPageController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnHapus2;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnTambah2;

    @FXML
    private Button btnTrans;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnUpdate2;

    @FXML
    private TableColumn<?, ?> colBarcode;

    @FXML
    private TableColumn<?, ?> colDayaTahan2;

    @FXML
    private TableColumn<?, ?> colDiskon;

    @FXML
    private TableColumn<?, ?> colDiskon2;

    @FXML
    private TableColumn<?, ?> colExpired;

    @FXML
    private TableColumn<?, ?> colHarga;

    @FXML
    private TableColumn<?, ?> colHarga2;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colID2;

    @FXML
    private TableColumn<?, ?> colJumlah;

    @FXML
    private TableColumn<?, ?> colJumlah2;

    @FXML
    private TableColumn<?, ?> colNama;

    @FXML
    private TableColumn<?, ?> colNama2;

    @FXML
    private TextField fieldBarcode;

    @FXML
    private TextField fieldDayaTahanM;

    @FXML
    private TextField fieldDiskonB;

    @FXML
    private TextField fieldDiskonM;

    @FXML
    private TextField fieldExpired;

    @FXML
    private TextField fieldHargaB;

    @FXML
    private TextField fieldHargaM;

    @FXML
    private TextField fieldIDMakanan;

    @FXML
    private TextField fieldIDbarang;

    @FXML
    private TextField fieldJumlahB;

    @FXML
    private TextField fieldJumlahM;

    @FXML
    private TextField fieldNamaB;

    @FXML
    private TextField fieldNamaM;

    @FXML
    void hapus(ActionEvent event) {
        SqlBarang brg = new SqlBarang();
        
        double hrgF = Double.parseDouble(fieldHargaB.getText());
        int jmlF = Integer.parseInt(fieldJumlahB.getText());
        double discF = Double.parseDouble(fieldDiskonB.getText());
        
        Barang brg1 = new Barang(fieldNamaB.getText(), hrgF, jmlF, discF);
        brg.dltMakananSQL(brg1);
    }

    @FXML
    void hapus2(ActionEvent event) {
        SqlMakanan mkn = new SqlMakanan();
        
        double harga = Double.parseDouble(fieldHargaM.getText());
        int jumlah = Integer.parseInt(fieldJumlahM.getText());
        double diskon = Double.parseDouble(fieldDiskonM.getText());
        
        Makanan mkn1 = new Makanan(fieldNamaM.getText(), harga, jumlah, diskon, fieldDayaTahanM.getText());
        mkn.dltMakananSQL(mkn1);
        
    }

    @FXML
    void pergiKeHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnHome.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pergiKeMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPage.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnMenu.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pergiKeTrans(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pembelian.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnTrans.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) {
        SqlBarang brg = new SqlBarang();
        double harga = Double.parseDouble(fieldHargaB.getText());
        int jumlah = Integer.parseInt(fieldJumlahB.getText());
        double diskon = Double.parseDouble(fieldDiskonB.getText());
        Barang brg1 = new Barang(fieldNamaB.getText(), harga, jumlah, diskon, fieldBarcode.getText(), fieldExpired.getText());
        brg.addBarangSQL(brg1);
    }

    @FXML
    void tambah2(ActionEvent event) {
        SqlMakanan mkn = new SqlMakanan();
        double harga = Double.parseDouble(fieldHargaM.getText());
        int jumlah = Integer.parseInt(fieldJumlahM.getText());
        double diskon = Double.parseDouble(fieldDiskonM.getText());
        Makanan mkn1 = new Makanan(fieldNamaM.getText(), harga, jumlah, diskon, fieldDayaTahanM.getText());
        mkn.addMakananSQL(mkn1);
    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void update2(ActionEvent event) {

    }
    
}
