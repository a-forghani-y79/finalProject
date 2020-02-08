package sample.TestTools.RAndD.Navigation_Drawer_Menu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AnchorPane anchor;
    public JFXHamburger jfxHamberger;
    public JFXDrawer jfxDrawer;
    private HamburgerBackArrowBasicTransition burgerTask2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            VBox vBox = FXMLLoader.load(getClass().getResource("sidePane.fxml"));
        jfxDrawer.setSidePane(vBox);


        burgerTask2 = new HamburgerBackArrowBasicTransition(jfxHamberger);
        burgerTask2.setRate(1.5);
        jfxHamberger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();


            if (jfxDrawer.isClosed())
                jfxDrawer.open();
            else
                jfxDrawer.close();
        });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
