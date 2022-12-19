package uap_pbo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController {

    @FXML
    private Button btnData;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnTrans;

    @FXML
    void pergiKeData(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBarangPage.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnData.getScene().getWindow();
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
    void pergiTrans(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pembelian.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnTrans.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
