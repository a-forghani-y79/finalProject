package sample.DataCenter.TablesDataModel;

import javafx.beans.property.SimpleStringProperty;

public class WeeklyScheduleMaster {
    final private SimpleStringProperty row;
    final private SimpleStringProperty lessonName;
    final private SimpleStringProperty value;
    final private SimpleStringProperty lissonCode;
    final private SimpleStringProperty numberOfSyudemtd;
    final private SimpleStringProperty holdingTime;

    public WeeklyScheduleMaster(String row, String lessonName, String value, String lessonCode, String numberOfSyudemtd, String holdingTime) {
        this.row = new SimpleStringProperty(row);
        this.lessonName = new SimpleStringProperty(lessonName);
        this.value = new SimpleStringProperty(value);
        this.lissonCode = new SimpleStringProperty(lessonCode);
        this.numberOfSyudemtd = new SimpleStringProperty(numberOfSyudemtd);
        this.holdingTime =new SimpleStringProperty(holdingTime);
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

    public String getLissonCode() {
        return lissonCode.get();
    }

    public SimpleStringProperty lissonCodeProperty() {
        return lissonCode;
    }

    public void setLissonCode(String lissonCode) {
        this.lissonCode.set(lissonCode);
    }

    public String getNumberOfSyudemtd() {
        return numberOfSyudemtd.get();
    }

    public SimpleStringProperty numberOfSyudemtdProperty() {
        return numberOfSyudemtd;
    }

    public void setNumberOfSyudemtd(String numberOfSyudemtd) {
        this.numberOfSyudemtd.set(numberOfSyudemtd);
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

}
