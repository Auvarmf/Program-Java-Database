package uap_pbo;

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
import javafx.stage.Stage;

public class MenuPageController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private Button btnData;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnTrans;

    @FXML
    void pergiKeData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBarangPage.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnData.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pergiKeHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnHome.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pergiTrans(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pembelian.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnTrans.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
}
