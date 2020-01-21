package sample.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class Student implements Initializable {
    sample.DataCenter.Student student;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("./sample/PNG/logoUni.png");

    }
}
