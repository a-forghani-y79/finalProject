package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class loginPageController implements Initializable {

    public AnchorPane paneBackground;
    public JFXTextField txtUser;
    public JFXTextField txtPass;
    public ImageView imgbackpane;
    public Label lblAlert;
    public JFXComboBox useCaseCombo;
    public TextArea txtInfo;
    public JFXButton btnExit;
    public ImageView exitButton;
    public ImageView infoBtn;
    public JFXButton btnDeletePass;
    public JFXButton btnDeleteUser;
    private ArchiveDataCenter archive;
    private StringBuilder stringBuilder;
    private int year;
    private String strYear;
    //passengers
    private NewStudentDataCenter passengerNewStudent;
    private MasterDataCenter passengerMaster;
    private StudentDataCenter passengerStudent;

    public TextArea getTxtInfo() {
        return txtInfo;
    }

    public void setTxtInfo(TextArea txtInfo) {
        this.txtInfo = txtInfo;
    }

    private void AnchorTime() {
        Image img;
        LocalDateTime KnowTime = LocalDateTime.now();
        if (KnowTime.getHour() >= 2 && KnowTime.getHour() < 4) {
            img = new Image("./sample/PNG/1pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() == 4) {
            img = new Image("./sample/PNG/2pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() >= 5 && KnowTime.getHour() < 7) {
            img = new Image("./sample/PNG/3pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() >= 7 && KnowTime.getHour() < 9) {
            img = new Image("./sample/PNG/4pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() >= 9 && KnowTime.getHour() < 12) {
            img = new Image("./sample/PNG/5pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() >= 12 && KnowTime.getHour() < 16) {
            img = new Image("./sample/PNG/6pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() == 16) {
            img = new Image("./sample/PNG/7pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() == 17) {
            img = new Image("./sample/PNG/8pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() == 18) {
            img = new Image("./sample/PNG/10pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() >= 19) {
            img = new Image("./sample/PNG/10pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour() < 2) {
            img = new Image("./sample/PNG/11pic.png");
            imgbackpane.setImage(img);
        }
    }

    public void DeleteUser() {
        txtUser.setText("");
    }

    public void DeletePass() {
        txtPass.setText("");
    }

    public void exitAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure " + "?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent())
            if (result.get() == ButtonType.YES)
                System.exit(0);
    }

    public void onClickSignIn() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        long UserNum = 0;
        long PassNum = 0;
        if (considerEmpty() && considerRight()) {
            UserNum = Long.parseLong(user);
            PassNum = Long.parseLong(pass);
        } else
            return;
        int useCaseIndex = useCaseCombo.getSelectionModel().getSelectedIndex();
        if (useCaseIndex == -1) {
            alert("نوع کاربری خود را انتخاب کنید", lblAlert, "red");
            return;
        }
        switch (useCaseIndex) {
            case 0:
                if (AuthNewStudent(UserNum, PassNum)){
                    passengerNewStudent = archive.readNewStudent(UserNum);
                    openFxmlNewStudent();
                }
                else {
                    alert("کاربری با این مشخصات یافت نشد", lblAlert, "red");
                    return;
                }
                break;
            case 1:
                if (AuthStudent(UserNum, PassNum))
                    openFxmlStudent();
                else {
                    alert("کاربری با این مشخصات یافت نشد", lblAlert, "red");
                    return;
                }
                break;
            case 2:
                if (AuthMaster(UserNum, PassNum))
                    openFxmlMaster();
                else {
                    alert("کاربری با این مشخصات یافت نشد", lblAlert, "red");
                    return;
                }
                break;
            case 3:
                if (AuthManager(UserNum, PassNum))
                    openFxmlManager();
                else {
                    alert("کاربری با این مشخصات یافت نشد", lblAlert, "red");
                    return;
                }
                break;
        }
    }

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void showText() {
        txtInfo.setVisible(true);
    }

    public void hideText() {
        txtInfo.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //AnchorTime();
        txtInfo.setVisible(false);
        String[] comboItems = {"دانشجو جدید الورود", "دانشجو", "استاد", "کارمند آموزش"};
        useCaseCombo.getItems().addAll(comboItems);
        useCaseCombo.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
    }

    private boolean AuthNewStudent(long userName, long passWord) {
        archive = new ArchiveDataCenter();
        NewStudentDataCenter std = archive.readNewStudent(userName);
        if (!(std == null))
            if (std.getFileNumber() == passWord)
                return true;
            else
                return false;
        else return false;
    }

    private boolean AuthStudent(long userName, long passWord) {
        System.out.println("std auth");
        archive = new ArchiveDataCenter();
        StudentDataCenter std = archive.readStudent(userName);
        if (!(std == null)){
            System.out.println("std not");
            System.out.println();
            if (std.getNationalCode() == passWord){
                passengerStudent = std;
                System.out.println("passenger setting");
                return true;}
            else
                return false;}
        else return false;
    }

    private boolean AuthMaster(long userName, long passWord) {

        archive = new ArchiveDataCenter();
        MasterDataCenter master = archive.readMaster(userName);
        if (!(master == null))
            if (master.getNationalNumber() == passWord){
                passengerMaster = master;
                return true;}
            else
                return false;
        else return false;
    }

    private boolean AuthManager(long userName, long passWord) {
        boolean flag = false;
        String user = String.valueOf(userName);
        String pass = String.valueOf(passWord);
        ManagerDataCenter manager = new ManagerDataCenter();
        HashingDataCenter hashing = new HashingDataCenter(user);
        user = hashing.getHash();
        hashing = new HashingDataCenter(pass);
        pass = hashing.getHash();
        if (user.equals(manager.getUserNameHash()) && pass.equals(manager.getPasswordNameHash()))
            flag = true;
        return flag;
    }

    private boolean considerEmpty() {
        boolean flag = true;
        String user = txtUser.getText();
        String pass = txtPass.getText();
        if (user.equals("") && pass.equals("")) {
            alert("لطفا نام کاربری و رمز عبور را وارد کنید", lblAlert, "red");
            flag = false;
        } else {
            if (user.equals("")) {
                alert("لطفا نام کاربری را وارد کنید", lblAlert, "red");
                flag = false;
            }
            if (pass.equals("")) {
                alert("لطفا رمز عبور را وارد کنید", lblAlert, "red");
                flag = false;
            }
        }
        return flag;
    }

    private boolean considerRight() {
        boolean flag = true;
        String user = txtUser.getText();
        String pass = txtPass.getText();
        int a = 0;
        int b = 0;
        if (!user.equals("") && !pass.equals("")) {
            for (int i = 0; i < user.length(); i++) {
                a = user.charAt(i);
                b = a - 48;
                if (!(b >= 0 && b <= 9)) {
                    alert("لطفا فقط عدد وارد کنید", lblAlert, "Red");
                    flag = false;
                }
            }
            int c = 0;
            int g = 0;
            for (int j = 0; j < pass.length(); j++) {
                c = pass.charAt(j);
                g = c - 48;
                if (!(g >= 0 && g <= 9)) {
                    alert("لطفا فقط عدد وارد کنید", lblAlert, "red");
                    flag = false;
                }
            }
        }
        return flag;
    }

    private void openFxmlNewStudent() {
        Parent root;
        try {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
            NewStudentController newStudentController = new NewStudentController();
            newStudentController.setStd(passengerNewStudent);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/NewStudent.fxml"));
            loader.setController(newStudentController);
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

    private void openFxmlManager() {
        Parent root;
        try {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
            ManagerController manager = new ManagerController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/Manager.fxml"));
            loader.setController(manager);
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

    private void openFxmlStudent() {
        Parent root;
        try {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
            StudentController studentController = new StudentController();
            studentController.setStudent(passengerStudent);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/Student.fxml"));
            loader.setController(studentController);
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

    private void openFxmlMaster() {
        Parent root;
        try {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
            MasterController masterController = new MasterController();
            masterController.setMaster(passengerMaster);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/Master.fxml"));
            loader.setController(masterController);
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