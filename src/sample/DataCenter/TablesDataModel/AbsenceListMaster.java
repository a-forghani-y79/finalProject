package sample.DataCenter.TablesDataModel;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public class AbsenceListMaster {
    private SimpleStringProperty row;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty studentCode;
    private JFXTextField numberOfAbsence;



    public AbsenceListMaster(String row, String lastName, String firstName, String studentCode, String numberOfAbsence) {
        this.row = new SimpleStringProperty(row);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.studentCode = new SimpleStringProperty(studentCode);
        this.numberOfAbsence = new JFXTextField(numberOfAbsence);
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

    public String getStudentCode() {
        return studentCode.get();
    }

    public SimpleStringProperty studentCodeProperty() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode.set(studentCode);
    }

    public JFXTextField getNumberOfAbsence() {
        return numberOfAbsence;
    }

    public int getAbsence() {
        return Integer.parseInt(numberOfAbsence.getText());
    }

    public void setNumberOfAbsence(JFXTextField numberOfAbsence) {
        this.numberOfAbsence = numberOfAbsence;
    }
}
