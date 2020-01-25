package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controllers.MasterController;
import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.MasterDataCenter;
import sample.DataCenter.NewStudentDataCenter;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MasterController master = new MasterController();
        MasterDataCenter masterDataCenter = new MasterDataCenter();
        FieldDataCenter fieldDataCenter = new FieldDataCenter();
        masterDataCenter.setGender(1);
        masterDataCenter.setLastName("aliPour");
        masterDataCenter.setFirstName("ali");
        fieldDataCenter.setMasterName(masterDataCenter.getFirstName() + " " + masterDataCenter.getLastName());
        fieldDataCenter.setClassStartTime("21-32-4");
        fieldDataCenter.setFieldName("math");
        fieldDataCenter.setFieldNumber(12345l);
        ArrayList<FieldDataCenter> fields = new ArrayList<>();
        fields.add(fieldDataCenter);
        masterDataCenter.setMasField(fields);
        master.setMaster(masterDataCenter);
        FXMLLoader loader = new FXMLLoader();

        Parent root;
        loader.setController(master);
        loader.setLocation(getClass().getResource("/sample/FXML/Master.fxml"));

        root = loader.load();

        //  primaryStage.setTitle("سیستم سما");

        primaryStage.setScene(new Scene(root, 1058, 600));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
