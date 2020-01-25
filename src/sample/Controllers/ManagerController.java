package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.DataCenter.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class ManagerController implements Initializable {
    public JFXButton btnBrowse;
    public JFXButton btnConfirm;
    public TextField txtPath;
    public JFXTextField txtFirstNameMaster;
    public JFXTextField txtLastNameMaster;
    public JFXTextField txtNationalNumberMaster;
    public JFXButton btnAddMaster;
    public JFXTextField txtFieldName;
    public JFXTextField txtFieldCode;
    public JFXTextField txtFieldUnit;
    public GridPane gridPaneProgram;
    public JFXButton btnChooseClassTime;
    public JFXTimePicker timePicker;
    public JFXDatePicker datePicker;
    public Label status;
    public JFXComboBox comboChooseMaster;
    public JFXComboBox comboGenderMaster;

    TextField txtYear;
    private FileChooser fileChooser;
    private Stage stage;
    private File file;
    private String addrCSV = "";
    private ImportNewStudentDataCenter importNewStudent;
    private ArchiveDataCenter archive;
    private int year;

    StudentIdGeneratorDataCenter idGenerator;

    //passengers
    MasterDataCenter master;
    FieldDataCenter field;


//TODO complete Label status and use an text field for getting year

    public void onClickAddMaster() {
        archive = new ArchiveDataCenter(year, ArchiveDataCenter.MASTER);
        master = new MasterDataCenter();
        idGenerator = new StudentIdGeneratorDataCenter();
        idGenerator.setYearNumber(98);
        long id = idGenerator.createIdMaster();
        int comboIndex = comboGenderMaster.getSelectionModel().getSelectedIndex();
        setDefaultColor();
        if (checkTextFieldMaster() && comboChecker(comboGenderMaster)) {
            master.setFirstName(txtFirstNameMaster.getText());
            master.setLastName(txtLastNameMaster.getText());
            master.setGender(comboIndex);
            master.setNationalNumber(Long.parseLong(txtNationalNumberMaster.getText()));
            master.setPersonalNumber(id);
            archive.writeMaster(master);
            System.out.println(archive.reportErrores());

            archive.close();
        }

        //TODO show master personal id && clear text fields
    }

    void setDefaultColor() {
        txtFirstNameMaster.setStyle("");
        txtNationalNumberMaster.setStyle("");
        txtLastNameMaster.setStyle("");
        comboGenderMaster.setStyle("");
    }


    boolean comboChecker(JFXComboBox comboBox) {
        if (comboBox.getSelectionModel().getSelectedIndex() >= 0)
            return true;
        else {
            comboBox.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
            return false;
        }
    }


    boolean checkTextFieldMaster() {
        boolean flag = true;
        if (!emptyChecker(txtFirstNameMaster)) {
            System.out.println("first is empty");
            flag = false;
            txtFirstNameMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        }
        if (!emptyChecker(txtLastNameMaster)) {
            flag = true;
            txtLastNameMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        }
        if (!emptyChecker(txtNationalNumberMaster)) {
            flag = true;
            txtNationalNumberMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        } else if (!(numChecker(txtNationalNumberMaster.getText()))) {
            txtNationalNumberMaster.setStyle("-fx-text-inner-color: rgb(255,0,0);");
            flag = false;
        }
        return flag;
    }


    public void onClickBrowse() {
        stage = (Stage) btnBrowse.getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv", "*.CSV"), new FileChooser.ExtensionFilter("Text File", "*.txt"));
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            addrCSV = file.getAbsolutePath();
            txtPath.setText(addrCSV);
            if (file.exists())
                btnConfirm.setDisable(false);
        }
    }

    public void onClickConfirm() {
        //String str = txtYear.getText();
        String str = "98";
        System.out.println(numChecker(str));
        if (numChecker(str)) {
            year = Integer.parseInt(str);
            importNewStudent = new ImportNewStudentDataCenter(addrCSV, year);
            status.setText(importNewStudent.getStatus());
        } else {

            status.setText("year not valid");
        }
    }

    boolean numChecker(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++)
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                flag = false;
                break;
            }
        return flag;
    }

    boolean emptyChecker(JFXTextField textField) {
        boolean flag = true;
        if (textField.getText().equals(""))
            flag = false;
        return flag;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        btnConfirm.setDisable(true);
        String[] gender = {"خانم", "آقا"};
        comboGenderMaster.getItems().addAll(gender);
        comboGenderMaster.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

    }
}
