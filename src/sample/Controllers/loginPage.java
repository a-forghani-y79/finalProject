package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.DataCenter.Hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class loginPage<imageView> implements Initializable {


    public AnchorPane paneBackground;
    public JFXTextField txtUser;
    public JFXTextField txtPass;
    public Label status;

    public ImageView imgbackpane;
    public Label UserJustNumber;
    public Label lblAlert;
    public JFXComboBox UseCaseCombo;
    public TextArea txtInfo;
    public JFXButton btnExit;


    public TextArea getTxtInfo() {
        return txtInfo;
    }

    public void setTxtInfo(TextArea txtInfo) {
        this.txtInfo = txtInfo;
    }




    public void AnchorTime(){
        Image img ;

        LocalDateTime KnowTime = LocalDateTime.now();
        System.out.println(KnowTime.getHour());

        if (KnowTime.getHour()>=2&&KnowTime.getHour()<4){
             img = new Image( "./sample/PNG/1pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=4&&KnowTime.getHour()<5){
            img = new Image("./sample/PNG/2pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=5&&KnowTime.getHour()<7){
            img = new Image("./sample/PNG/3pic.png");

            imgbackpane.setImage(img);

        }
        if (KnowTime.getHour()>=7&&KnowTime.getHour()<9){
            img = new Image("./sample/PNG/4pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=9&&KnowTime.getHour()<12){
            img = new Image("./sample/PNG/5pic.png");
            imgbackpane.setImage(img);

        }
        if (KnowTime.getHour()>=12&&KnowTime.getHour()<16){
            img = new Image("./sample/PNG/6pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=16&&KnowTime.getHour()<17){
            img  =new Image("./sample/PNG/7pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=17&&KnowTime.getHour()<18){
            img = new Image("./sample/PNG/8pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=18&&KnowTime.getHour()<19){

            img = new Image("./sample/PNG/10pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=19&&KnowTime.getHour()<24){
            img = new Image("./sample/PNG/10pic.png");
            imgbackpane.setImage(img);
        }
        if (KnowTime.getHour()>=0&&KnowTime.getHour()<2){
            img = new Image("./sample/PNG/11pic.png");
            imgbackpane.setImage(img);
        }

    }





    Hashing hashing;

    FXMessageDialog fxMessageDialog ;


    public  void DeleteUser (){
        txtUser.setText("");

    }

    public void  DeletePass(){
        txtPass.setText("");

    }




    public void exitAlert ()
    {
        Alert alert =new Alert(Alert.AlertType.WARNING,"Are you sure "+ "?", ButtonType.YES,ButtonType.NO);



       Optional<ButtonType> result = alert.showAndWait();

       if(result.get()== ButtonType.YES)

           System.exit(0);




    }


    public void onClickSignIn() {

        String user = txtUser.getText();
        String pass = txtPass.getText();

        long UserNum =0;
        long PassNum =0;

//        UserNum = Long.parseLong(user);
//        PassNum = Long.parseLong(pass);


            considerEmpty();
            considerRight();


        auth(user,pass);

//        if(!(user.equals("")&&pass.equals(""))) {
//            UserNum = Long.parseLong(user);
//            PassNum = Long.parseLong(pass);
//        }
//        else {
//            if (user.equals(""))
//                alert("لطفا نام کاربری را وارد کنید", lblAlert, "red");
//            if (pass.equals(""))
//                alert("لطفا رمز عبور را وارد کنید", lblAlert, "red");
//        }






         int UseCaseIndex = UseCaseCombo.getSelectionModel().getSelectedIndex();

         switch (UseCaseIndex){
             case 0 :
                AuthNewStudent(UserNum,PassNum);
                 break;
             case 1 :
                AuthStudent(UserNum,PassNum);
                 break;
             case 2:
                AuthMaster(UserNum,PassNum);
                 break;
             case 3:
                AuthManager(UserNum,PassNum);
                 break;

         }




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

    public void showText()
    {
       txtInfo.setVisible(true);

    }
    public void hideText()
    {
        txtInfo.setVisible(false);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  AnchorTime();



        String[] comboItems = {"دانشجو جدید الورود","دانشجو","استاد","کارمند آموزش"};


        UseCaseCombo.getItems().addAll(comboItems);
        UseCaseCombo.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);








    }

    public  void AuthNewStudent(long UserName,long PassWord){


    }
    public  void AuthStudent(long UserName,long PassWord){



    }
    public  void AuthMaster(long UserName,long PassWord){



    }
    public  void AuthManager(long UserName,long PassWord){



    }


    public void considerEmpty()
    {
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if(user.equals("")&&pass.equals(""))
            alert("لطفا نام کاربری و رمز عبور را وارد کنید",lblAlert,"red");


        else {
            if (user.equals(""))
                alert("لطفا نام کاربری را وارد کنید", lblAlert, "red");
            if (pass.equals(""))
                alert("لطفا رمز عبور را وارد کنید", lblAlert, "red");
        }



    }

      public void considerRight()
    {

        String user = txtUser.getText();
        String pass = txtPass.getText();

       int a= 0;
       int b=0;

        if(!user.equals("")&&!pass.equals("")) {



            for (int i = 0; i < user.length(); i++) {
                a= user.charAt(i);b=a-48;
                if (!(b >= 0 &&   b <= 9))
                    alert("لطفا فقط عدد وارد کنید", lblAlert, "Red");

            }
            int c= 0;
            int g=0;

            for (int j = 0; j < pass.length(); j++) {
                c= user.charAt(j);g=a-48;
                if (!(g >= 0 && g <= 9))
                alert("لطفا فقط عدد وارد کنید", lblAlert, "red");
            }

        }



    }










}





