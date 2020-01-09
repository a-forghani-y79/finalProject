package sample.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.DataCenter.Hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class loginPage implements Initializable {


    public AnchorPane paneBackground;
    public TextField txtUser;
    public PasswordField txtPass;
    public Label status;



    Hashing hashing;

    void omClickSignIn() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        auth(user,pass);



    }

     boolean auth(String user, String pass) {

        try {
            hashing = new Hashing(null);
            BufferedReader bf = new BufferedReader(new FileReader("./src/sample/Files/Auth"));
            String userHash = bf.readLine();
            String passHash = bf.readLine();
            hashing.setMessage(user);
            user = hashing.getHash();
            hashing.setMessage(pass);
            pass = hashing.getHash();
            if (userHash.equals(user) && passHash.equals(pass))
                return true;
            else
                return false;
        } catch (Exception e) {
            alert("Error: " + e.getMessage(), status, "red");
            return false;
        }


    }

     void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("hi baby");

    }
}
