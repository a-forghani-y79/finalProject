package sample.DataCenter.TablesDataModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportStudent {
            private SimpleStringProperty row;
            private SimpleStringProperty lessonName;
            private SimpleStringProperty value;
            private SimpleStringProperty masterName;
            private SimpleStringProperty grade;
            private SimpleStringProperty situation;

    public ReportStudent(String row, String lessonName, String value,
                         String masterName, String grade, String situation) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
        this.masterName = new SimpleStringProperty(masterName);
        this.grade = new SimpleStringProperty(grade);
        this.situation = new SimpleStringProperty(situation);
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

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getSituation() {
        return situation.get();
    }

    public SimpleStringProperty situationProperty() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation.set(situation);
    }
}
