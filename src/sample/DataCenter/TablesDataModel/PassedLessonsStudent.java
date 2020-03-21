package sample.DataCenter.TablesDataModel;

import javafx.beans.property.SimpleStringProperty;

public class PassedLessonsStudent {

    private SimpleStringProperty row;
    private SimpleStringProperty lessonName;
    private SimpleStringProperty value;
    private SimpleStringProperty masterName;
    private SimpleStringProperty grade;

    public PassedLessonsStudent(String row, String lessonName, String value, String masterName, String grade) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
        this.masterName = new SimpleStringProperty(masterName);
        this.grade = new SimpleStringProperty(grade);
    }

    public void setRow(String row) {
        this.row.set(row);
    }

    public void setLessonName(String lessonName) {
        this.lessonName.set(lessonName);
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public void setMasterName(String masterName) {
        this.masterName.set(masterName);
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
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

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }
}
