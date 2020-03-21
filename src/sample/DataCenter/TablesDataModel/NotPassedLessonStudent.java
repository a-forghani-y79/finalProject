package sample.DataCenter.TablesDataModel;

import javafx.beans.property.SimpleStringProperty;

public class NotPassedLessonStudent {
    private SimpleStringProperty row;
    private SimpleStringProperty lessonName;
    private SimpleStringProperty value;

    public NotPassedLessonStudent(String row, String lessonName, String value) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
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
}
