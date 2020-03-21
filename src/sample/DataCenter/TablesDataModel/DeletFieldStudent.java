package sample.DataCenter.TablesDataModel;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeletFieldStudent {

    private SimpleStringProperty row;
    private SimpleStringProperty lessonCode;
    private SimpleStringProperty lessonName;
    private SimpleStringProperty value;
    private SimpleStringProperty masterName;
    private SimpleStringProperty holdingTime;
    private SimpleStringProperty examTime;
    private JFXToggleButton button;

    public DeletFieldStudent(String row, String lessonCode, String lessonName,
                             String value, String masterName, String holdingTime,
                             String examTime) {
        this.row = new SimpleStringProperty(row);
        this.lessonCode = new SimpleStringProperty(lessonCode);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
        this.masterName = new SimpleStringProperty(masterName);
        this.holdingTime = new SimpleStringProperty(holdingTime);
        this.examTime = new SimpleStringProperty(examTime);
        this.button = new JFXToggleButton();
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

    public void setLessonCode(String lessonCode) {
        this.lessonCode.set(lessonCode);
    }

    public String getLessonName() {
        return lessonName.get();
    }

    public SimpleStringProperty lessonNameProperty() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName.set(lessonName);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public String getMasterName() {
        return masterName.get();
    }

    public SimpleStringProperty masterNameProperty() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public String getHoldingTime() {
        return holdingTime.get();
    }

    public SimpleStringProperty holdingTimeProperty() {
        return holdingTime;
    }

    public void setHoldingTime(String holdingTime) {
        this.holdingTime.set(holdingTime);
    }

    public String getExamTime() {
        return examTime.get();
    }

    public SimpleStringProperty examTimeProperty() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime.set(examTime);
    }

    public void setButton(JFXToggleButton button) {
        this.button = button;
    }

    public String getLessonCode() {
                return lessonCode.get();
        }

        public SimpleStringProperty lessonCodeProperty() {
                return lessonCode;
        }

        public JFXToggleButton getButton() {
                return button;
        }
}
