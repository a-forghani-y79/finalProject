package sample;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Controller  implements Initializable {


    public AnchorPane pane;
    public  void test(){
        LocalDateTime myobj = LocalDateTime.now();
        System.out.println(myobj.getHour());

        //pane.setStyle("-fx-background-image: /sample/FXML/PNG/1pic.png");
        pane.setStyle("-fx-background-image: url(../sample/PNG/1pic.png)");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //test();

    }
}
