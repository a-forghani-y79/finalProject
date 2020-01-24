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
import sample.DataCenter.Archive;
import sample.DataCenter.Master;
import sample.DataCenter.NewStudent;
import sample.DataCenter.Student;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class loginPage implements Initializable {


    public AnchorPane paneBackground;
    public JFXTextField txtUser;
    public JFXTextField txtPass;

    public ImageView imgbackpane;
    public Label lblAlert;
    public JFXComboBox useCaseCombo;
    public TextArea txtInfo;
    public JFXButton btnExit;
    private Archive archive;
    private StringBuilder stringBuilder;
    private int year;
    private String strYear;

    //passengers
    private NewStudent passengerNewStudent;
    private Master passengerMaster;
    private Student passengerStudent;


    public TextArea getTxtInfo() {
        return txtInfo;
    }

    public void setTxtInfo(TextArea txtInfo) {
        this.txtInfo = txtInfo;
    }


    private void AnchorTime() {
        Image img;

        LocalDateTime KnowTime = LocalDateTime.now();
        System.out.println(KnowTime.getHour());

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
            //TODO set suitable message

            return;
        }


        switch (useCaseIndex) {
            case 0:
                if (AuthNewStudent(UserNum, PassNum))
                    openFxmlNewStudent();
                else {
                    //  alert();
                    //TODO set suitable message

                    return;
                }
                break;
            case 1:
                if (AuthStudent(UserNum, PassNum))
                    openFxmlStudent();
                else {
                    //  alert();
                    //TODO set suitable message
                    return;
                }
                break;
            case 2:
                if (AuthMaster(UserNum, PassNum))
                    openFxmlMaster();
                else {
                    //  alert();
                    //TODO set suitable message
                    return;
                }
                break;
            case 3:
                if (AuthManager(UserNum, PassNum))
                    openFxmlManager();
                else {
                    //  alert();
                    //TODO set suitable message
                    return;
                }
                break;

        }


    }

//    boolean auth(String user, String pass) {
//
//
//        try {
//            Hashing hashing = new Hashing(null);
//            BufferedReader bf = new BufferedReader(new FileReader("./src/sample/Files/Auth"));
//            String userHash = bf.readLine();
//            String passHash = bf.readLine();
//            hashing.setMessage(user);
//            user = hashing.getHash();
//            hashing.setMessage(pass);
//            pass = hashing.getHash();
//            if (userHash.equals(user) && passHash.equals(pass))
//                return true;
//            else
//                return false;
//        } catch (Exception e) {
//            alert("Error: " + e.getMessage(), lblAlert, "red");
//            return false;
//        }
//
//
//    }

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
        AnchorTime();
        String[] comboItems = {"دانشجو جدید الورود", "دانشجو", "استاد", "کارمند آموزش"};
        useCaseCombo.getItems().addAll(comboItems);
        useCaseCombo.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);


    }

    private boolean AuthNewStudent(long userName, long passWord) {
        stringBuilder = new StringBuilder("" + userName);
        strYear = (String) stringBuilder.subSequence(0, 2);
        year = Integer.parseInt(strYear);
        archive = new Archive(year, Archive.NEW_STUDENT);
        NewStudent std = archive.readNewStudent(userName);
        if (!(std == null))
            if (std.getFileNumber() == passWord)
                return true;
            else
                return false;
        else return false;
    }

    private boolean AuthStudent(long userName, long passWord) {
        stringBuilder = new StringBuilder("" + userName);
        strYear = (String) stringBuilder.subSequence(0, 2);
        year = Integer.parseInt(strYear);
        archive = new Archive(year, Archive.STUDENT);
        Student std = archive.readStudent(userName);
        if (!(std == null))
            if (std.getFileNumber() == passWord)
                return true;
            else
                return false;
        else return false;
    }

    private boolean AuthMaster(long userName, long passWord) {
        return true;

    }

    private boolean AuthManager(long userName, long passWord) {


        return true;
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
                c = user.charAt(j);
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
            sample.Controllers.NewStudent newStudentController = new sample.Controllers.NewStudent();
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
            Manager manager = new Manager();


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
            sample.Controllers.Student studentController = new sample.Controllers.Student();
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
            sample.Controllers.Master masterController = new sample.Controllers.Master();
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





