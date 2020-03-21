package sample.DataCenter.TablesDataModel;

import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;

public class AddFieldMaster {

    private SimpleStringProperty lessonName;
    private SimpleStringProperty lessonCode;
    private SimpleStringProperty value;
    private SimpleStringProperty holdingTime;
    private JFXToggleButton add;


    public AddFieldMaster(String lessonName, String lessonCode, String value, String holdingTime, JFXToggleButton add) {
        this.lessonName = new SimpleStringProperty(lessonName);
        this.lessonCode = new SimpleStringProperty(lessonCode);
        this.value = new SimpleStringProperty(value);
        this.holdingTime = new SimpleStringProperty(holdingTime);
        this.add = add;
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

    public String getLessonCode() {
        return lessonCode.get();
    }

    public SimpleStringProperty lessonCodeProperty() {
        return lessonCode;
    }

    public void setLessonCode(String lessonCode) {
        this.lessonCode.set(lessonCode);
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

    public String getHoldingTime() {
        return holdingTime.get();
    }

    public SimpleStringProperty holdingTimeProperty() {
        return holdingTime;
    }

    public void setHoldingTime(String holdingTime) {
        this.holdingTime.set(holdingTime);
    }

    public JFXToggleButton getAdd() {
        return add;
    }

    public void setAdd(JFXToggleButton add) {
        this.add = add;
    }

}
