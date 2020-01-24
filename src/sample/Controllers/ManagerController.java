package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.ImportNewStudentDataCenter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class ManagerController implements Initializable {
    public JFXButton btnBrowse;
    public JFXButton btnImport;
    public JFXTextArea txtAreaPreview;
    public TextField txtPath;
    public JFXButton btnConfirm;
    public JFXTextField txtFirstNameMaster;
    public JFXTextField txtFamilyMaster;
    public JFXTextField txtNationalNumberMaster;
    public JFXButton btnAddMaster;
    public JFXTextField txtFieldName;
    public JFXTextField txtFieldCode;
    public JFXTextField txtFieldUnit;
    public GridPane gridPaneProgram;
    public JFXComboBox comboFieldMaster;
    public JFXButton btnChooseClassTime;
    public JFXTimePicker timePicker;
    public JFXDatePicker datePicker;
    public JFXButton btnExit1;
    public JFXButton btnBack1;
    public ImageView imageExit1;
    public ImageView imageBack1;
    public JFXButton btnExit2;
    public ImageView imageExit2;
    public JFXButton btnBack2;
    public ImageView imageBack2;
    public JFXButton btnExit3;
    public JFXButton btnBack3;
    public ImageView imageExit3;
    public ImageView imageBack3;
    TextField txtAddress;
    TextField txtYear;
    FileChooser fileChooser;
    Stage stage;
    File file;
    String addrCSV = "";
    ImportNewStudentDataCenter importNewStudent;
    int year;
    public Label status;


    public void onClickBrowse() {
        stage = (Stage) btnBrowse.getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv", "*.CSV"), new FileChooser.ExtensionFilter("Text File", "*.txt"));
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            addrCSV = file.getAbsolutePath();
            if (file.exists())
                btnImport.setDisable(false);
        }
    }

    public void onClickImport() {
        String str = txtYear.getText();
        if (numChecker(str)) {
            year = Integer.parseInt(str);
            importNewStudent = new ImportNewStudentDataCenter(addrCSV, year);

        } else {
            status.setText("year not valid");
        }
    }

    boolean numChecker(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) >= 0 && str.charAt(i) <= 9) {
                flag = false;
                break;
            }

        return flag;
    }
    public void setImage(){
        Image img ;
        img = new Image("./sample/PNG/Exit.png");
        imageExit1.setImage(img);
        imageExit2.setImage(img);
        imageExit3.setImage(img);
        img = new Image("./sample/PNG/Back.png");
        imageBack1.setImage(img);
        imageBack2.setImage(img);
        imageBack3.setImage(img);
    }

    @FXML
    private void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure " + "?", ButtonType.YES, ButtonType.NO);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {
                System.exit(0);
            }
        }
    }

    @FXML
    private void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure " + "?", ButtonType.YES, ButtonType.NO);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {

                Parent root;

                try {
                    Stage stage = (Stage) btnBack1.getScene().getWindow();
                    stage.close();


                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/loginPage.fxml"));
                    root = loader.load();
                    stage = new Stage();

                    Stage finalStage = stage;

                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root));
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        btnImport.setDisable(true);
        setImage();

    }
}
