package sample.Controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public ImageView imgbackpane;


    public void AnchorTime(){
        Image img ;

        LocalDateTime KnowTime = LocalDateTime.now();
        System.out.println(KnowTime.getHour());

        if (KnowTime.getHour()>=2&&KnowTime.getHour()<4){
             img = new Image( "../src/sample/PNG/1pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=4&&KnowTime.getHour()<5){
            img = new Image("../src/sample/PNG/2pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=5&&KnowTime.getHour()<7){
            img = new Image("../src/sample/PNG/3pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=7&&KnowTime.getHour()<9){
            img = new Image("../src/sample/PNG/4pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=9&&KnowTime.getHour()<12){
            img = new Image("../src/sample/PNG/5pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=12&&KnowTime.getHour()<16){
            img = new Image("..src/sample/PNG/6pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=16&&KnowTime.getHour()<17){
            img  =new Image("..src/sample/PNG/7pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=17&&KnowTime.getHour()<18){
            img = new Image("..src/sample/PNG/8pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=18&&KnowTime.getHour()<19){
            img = new Image("..src/sample/PNG/9pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=19&&KnowTime.getHour()<24){
            img = new Image("./sample/PNG/10pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=0&&KnowTime.getHour()<2){
            img = new Image("..src/sample/PNG/11pic.png");
            imgbackpane.setImage(img);
        }

    }


    Hashing hashing;

    public void onClickSignIn() {

        String user = txtUser.getText();
        String pass = txtPass.getText();

        for (int i = 0; i <user.length() ; i++) {
            if(user.charAt(i)>=0 && user.charAt(i)<=9);
                // show error Massage
        }
        for (int j = 0; j <pass.length() ; j++) {
            if(!(user.charAt(j)>=0 && user.charAt(j)<=9));
            // show error Massage
        }


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
