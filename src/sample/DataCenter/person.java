package sample.DataCenter;

import javafx.scene.control.Button;

public class person {
    private int row ;
    private String lesson = null;
    private int lessonCod ;
    private String master = null;
    private int unit ;
    private String classStartTime = null;
    private String timeToTakeExam = null;
    private Button btnChooseUnit = null;
    private double score ;
    private String situation = null;
    private int numberOfAbsence ;
    private int studentNumber;



    private int passedStudentNumber;

    //Choose units
    public person(int row, String lesson, int lessonCode, String master, int unit, String classStartTime, String timeToTakeExam,Button btnChooseUnit) {
        System.out.println("dcx");
        this.row = row;
        this.lesson = lesson;
        this.lessonCod = lessonCode;
        this.master = master;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.timeToTakeExam = timeToTakeExam;
        this.btnChooseUnit = btnChooseUnit;

    }

    //Report
    public  person(int row, String lesson, int unit, String master, double Score, String situation) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = Score;
        this.situation = situation;
    }

    //Curriculum
    public  person(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.timeToTakeExam = timeToTakeExam;
        this.numberOfAbsence = numberOfAbsence;

    }

    //Passed
    public  person(int row, String lesson, int unit, String master, double score) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = score;
    }

    //not Passed
    public  person(int row, String lesson, int unit) {
        this.row = row;
        this.lesson = lesson;
        this.unit = unit;

    }

    public  person(String lesson,int lessonCod,int unit,int studentNumber,int passedStudentNumber){
        this.lesson = lesson;
        this.lessonCod = lessonCod;
        this.unit = unit;
        this.studentNumber = studentNumber;
        this.passedStudentNumber = passedStudentNumber;



    }

    public String getLesson() {
        System.out.println("efds");
        return lesson;
    }

    public int getRow() {
        return row;
    }

    public int getLessonCod() {
        return lessonCod;
    }

    public String getMaster() {
        return master;
    }

    public int getUnit() {
        return unit;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public String getTimeToTakeExam() {
        return timeToTakeExam;
    }

    public double getScore() {
        return score;
    }

    public String getSituation() {
        return situation;
    }

    public Button getBtnChooseUnit() {
        return btnChooseUnit;
    }

    public int getNumberOfAbsence() {
        return numberOfAbsence;
    }
    public int getStudentNumber() {
        System.out.println("124");
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getPassedStudentNumber() {
        System.out.println("124");
        return passedStudentNumber;
    }

    public void setPassedStudentNumber(int passedStudentNumber) {
        this.passedStudentNumber = passedStudentNumber;
    }


}
