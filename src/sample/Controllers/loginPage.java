package sample.Controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.DataCenter.Hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class loginPage implements Initializable {


    public AnchorPane paneBackground;
    public TextField txtUser;
    public PasswordField txtPass;
    public Label status;
    public JFXTextField ghader;


    public void AnchorTime(){
        LocalDateTime KnowTime = LocalDateTime.now();
        if (KnowTime.getHour()>2&&KnowTime.getHour()<4){

        }
        if (KnowTime.getHour()>4&&KnowTime.getHour()<5){

        }
        if (KnowTime.getHour()>5&&KnowTime.getHour()<7){

        }
        if (KnowTime.getHour()>7&&KnowTime.getHour()<9){

        }
        if (KnowTime.getHour()>9&&KnowTime.getHour()<12){

        }
        if (KnowTime.getHour()>12&&KnowTime.getHour()<16){

        }
        if (KnowTime.getHour()>16&&KnowTime.getHour()<17){

        }
        if (KnowTime.getHour()>17&&KnowTime.getHour()<18){

        }
        if (KnowTime.getHour()>18&&KnowTime.getHour()<19){

        }
        if (KnowTime.getHour()>19&&KnowTime.getHour()<24){

        }
        if (KnowTime.getHour()>0&&KnowTime.getHour()<2){

        }

    }


    Hashing hashing;

    public void onClickSignIn() {
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
        AnchorTime();
        System.out.println("hi baby");

    }
}
