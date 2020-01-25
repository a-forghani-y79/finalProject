package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.DataCenter.ImportNewStudent;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Manager implements Initializable {
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
    TextField txtAddress;
    TextField txtYear;
    FileChooser fileChooser;
    Stage stage;
    File file;
    String addrCSV = "";
    ImportNewStudent importNewStudent;
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
            importNewStudent = new ImportNewStudent(addrCSV, year);

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        btnImport.setDisable(true);

    }
}
