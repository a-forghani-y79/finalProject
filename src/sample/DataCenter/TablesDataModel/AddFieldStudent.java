package sample.DataCenter.TablesDataModel;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ToggleButton;

import java.security.SignatureSpi;

public class AddFieldStudent {

    private SimpleStringProperty row;
    private SimpleStringProperty lessonName;
    private SimpleStringProperty lessonCode;
    private SimpleStringProperty value;
    private SimpleStringProperty masterName;
    private SimpleStringProperty holdingTime;
    private SimpleStringProperty examTime;
    private JFXToggleButton add;

    public AddFieldStudent(String row, String lessonName, String lessonCode, String value, String masterName,
                           String holdingTime, String examTime) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.lessonCode = new SimpleStringProperty(lessonCode);
        this.value = new SimpleStringProperty(value);
        this.masterName = new SimpleStringProperty(masterName);
        this.holdingTime = new SimpleStringProperty(holdingTime);
        this.examTime = new SimpleStringProperty(examTime);
        this.add = new JFXToggleButton();
    }

    public void setRow(String row) {
        this.row.set(row);
    }

    public void setLessonName(String lessonName) {
        this.lessonName.set(lessonName);
    }

    public void setLessonCode(String lessonCode) {
        this.lessonCode.set(lessonCode);
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public void setHoldingTime(String holdingTime) {
        this.holdingTime.set(holdingTime);
    }

    public void setExamTime(String examTime) {
        this.examTime.set(examTime);
    }

    public void setAdd(JFXToggleButton add) {
        this.add = add;
    }

    public String getRow() {
        return row.get();
    }

    public SimpleStringProperty rowProperty() {
        return row;
    }

    public String getLessonName() {
        return lessonName.get();
    }

    public SimpleStringProperty lessonNameProperty() {
        return lessonName;
    }

    public String getLessonCode() {
        return lessonCode.get();
    }

    public SimpleStringProperty lessonCodeProperty() {
        return lessonCode;
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public String getMasterName() {
        return masterName.get();
    }

    public SimpleStringProperty masterNameProperty() {
        return masterName;
    }

    public String getHoldingTime() {
        return holdingTime.get();
    }

    public SimpleStringProperty holdingTimeProperty() {
        return holdingTime;
    }

    public String getExamTime() {
        return examTime.get();
    }

    public SimpleStringProperty examTimeProperty() {
        return examTime;
    }

    public JFXToggleButton getAdd() {
        return add;
    }
}
