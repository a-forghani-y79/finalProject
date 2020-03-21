package sample.DataCenter.TablesDataModel;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public class InsertGradeMaster {
    private SimpleStringProperty row;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty studentNumber;
    private SimpleStringProperty gender;
    private JFXTextField insertGrade;

    public InsertGradeMaster(String row, String lastName, String firstName, String studentNumber, String gender, String insertGrade) {
        this.row = new SimpleStringProperty(row);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.studentNumber = new SimpleStringProperty(studentNumber);
        this.gender = new SimpleStringProperty(gender);
        this.insertGrade = new JFXTextField(insertGrade);
    }

    public JFXTextField getInsertGrade() {
        return insertGrade;
    }

    public String getRow() {
        return row.get();
    }

    public SimpleStringProperty rowProperty() {
        return row;
    }

    public void setRow(String row) {
        this.row.set(row);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getStudentNumber() {
        return studentNumber.get();
    }

    public SimpleStringProperty studentNumberProperty() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber.set(studentNumber);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public double getGrade() {
        return Double.parseDouble(insertGrade.getText());
    }

    public void setInsertGrade(JFXTextField insertGrade) {
        this.insertGrade = insertGrade;
    }
}
