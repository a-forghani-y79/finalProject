package sample.DataCenter.TablesDataModel;

import javafx.beans.property.SimpleStringProperty;

public class CurriculumStudent {
    private SimpleStringProperty row;
    private SimpleStringProperty lessonName;
    private SimpleStringProperty value;
    private SimpleStringProperty masterName;
    private SimpleStringProperty holdingTime;
    private SimpleStringProperty examTime;
    private SimpleStringProperty numberOfAbsence;

    public CurriculumStudent(String row, String lessonName, String value,
                             String masterName, String holdingTime, String examTime, String numberOfAbsence) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
        this.masterName = new SimpleStringProperty(masterName);
        this.holdingTime = new SimpleStringProperty(examTime);
        this.examTime = new SimpleStringProperty(examTime);
        this.numberOfAbsence = new SimpleStringProperty(numberOfAbsence);
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

    public String getNumberOfAbsence() {
        return numberOfAbsence.get();
    }

    public SimpleStringProperty numberOfAbsenceProperty() {
        return numberOfAbsence;
    }

    public void setNumberOfAbsence(String numberOfAbsence) {
        this.numberOfAbsence.set(numberOfAbsence);
    }
}
