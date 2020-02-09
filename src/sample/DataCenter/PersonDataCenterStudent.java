package sample.DataCenter;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.util.Date;


public class PersonDataCenterStudent {
    private int row;
    private String lesson;
    private long lessonCod;
    private String master;
    private int unit;
    private String classStartTime;
    private String timeToTakeExam;
    private JFXToggleButton togglebtnChooseUnit;
    private double score;
    private String situation;
    private int numberOfAbsence;
    // private int studentNumber;
    private String classPlace;
    // private String firstName = null;
    //   private String lastName = null;
    private String gender;


    private int passedStudentNumber;


    //Choose units
    public PersonDataCenterStudent(int row, String lesson, Long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, JFXToggleButton btnChooseUnit) {
        this.row = row;
        this.lesson = lesson;
        this.lessonCod = lessonCode;
        this.master = master;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.timeToTakeExam = timeToTakeExam;
        this.togglebtnChooseUnit = btnChooseUnit;
    }


    //Report
    public PersonDataCenterStudent(int row, String lesson, int unit, String master, double Score, String situation) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = Score;
        this.situation = situation;
    }

    //Curriculum
    public PersonDataCenterStudent(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.timeToTakeExam = timeToTakeExam;
        this.numberOfAbsence = numberOfAbsence;
    }

    //Passed
    public PersonDataCenterStudent(int row, String lesson, int unit, String master, double score) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = score;
    }

    //not Passed
    public PersonDataCenterStudent(int row, String lesson, int unit) {
        this.row = row;
        this.lesson = lesson;
        this.unit = unit;
    }



//    public PersonDataCenterStudent(String lesson, int lessonCod, int unit, String classStartTime, JFXToggleButton btnChooseUnit) {
//        this.lesson = lesson;
//        this.lessonCod = lessonCod;
//        this.unit = unit;
//        this.classStartTime = classStartTime;
//        this.togglebtnChooseUnit = btnChooseUnit;
//    }






    public PersonDataCenterStudent(String lessonName, long lessonCode, int unit, String classStartTime, JFXToggleButton toggleButton) {
        this.lesson = lessonName;
        this.lessonCod = lessonCode;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.togglebtnChooseUnit = toggleButton;
    }



    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public long getLessonCod() {
        return lessonCod;
    }

    public void setLessonCod(int lessonCod) {
        this.lessonCod = lessonCod;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getTimeToTakeExam() {
        return timeToTakeExam;
    }

    public void setTimeToTakeExam(String timeToTakeExam) {
        this.timeToTakeExam = timeToTakeExam;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public int getNumberOfAbsence() {
        return numberOfAbsence;
    }


    public int getPassedStudentNumber() {
        return passedStudentNumber;
    }

    public void setPassedStudentNumber(int passedStudentNumber) {
        this.passedStudentNumber = passedStudentNumber;
    }

    public void setNumberOfAbsence(int numberOfAbsence) {
        this.numberOfAbsence = numberOfAbsence;
    }

    public void setLessonCod(long lessonCod) {
        this.lessonCod = lessonCod;
    }

    public String getClassPlace() {
        return classPlace;
    }

    public void setClassPlace(String classPlace) {
        this.classPlace = classPlace;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public JFXToggleButton getToggleBtnChooseUnit() {
        return togglebtnChooseUnit;
    }

    public void setTogglebtnChooseUnit(JFXToggleButton togglebtnChooseUnit) {
        this.togglebtnChooseUnit = togglebtnChooseUnit;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


}