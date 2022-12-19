package uap_pbo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private TextField fieldUsername;
        
    @FXML
    void pergiKeHome(ActionEvent event) throws IOException {
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        
        if(username.equalsIgnoreCase("auvarmf") && password.equalsIgnoreCase("12345678")){
            JOptionPane.showMessageDialog(null, "Login Success");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        }else{
            JOptionPane.showMessageDialog(null, "Login Failed. " + "Please try again!");
        }
        
    }
    
}
