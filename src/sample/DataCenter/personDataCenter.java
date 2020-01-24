package sample.DataCenter;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;


public class personDataCenter {
    private int row;
    private String lesson = null;
    private long lessonCod ;
    private String master = null;
    private int unit ;
    private String classStartTime = null;
    private String timeToTakeExam = null;
    private JFXToggleButton btnChooseUnit = null;
    private double score ;
    private String situation = null;
    private int numberOfAbsence ;
    private int studentNumber;
    private  String classPlace=null;
    private String firstName = null;
    private String lastName = null;
    private long studentId  ;
    private String gender = null;
    private TextField txtInsert;










    private int passedStudentNumber;

    //Choose units
    public personDataCenter(int row, String lesson, Long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, JFXToggleButton btnChooseUnit) {
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
    public personDataCenter(int row, String lesson, int unit, String master, double Score, String situation) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = Score;
        this.situation = situation;
    }

    //Curriculum
    public personDataCenter(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.classStartTime = classStartTime;
        this.timeToTakeExam = timeToTakeExam;
        this.numberOfAbsence = numberOfAbsence;

    }

    //Passed
    public personDataCenter(int row, String lesson, int unit, String master, double score) {
        this.row = row;
        this.lesson = lesson;
        this.master = master;
        this.unit = unit;
        this.score = score;
    }

    //not Passed
    public personDataCenter(int row, String lesson, int unit) {
        this.row = row;
        this.lesson = lesson;
        this.unit = unit;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public personDataCenter(String lesson, int lessonCod, int unit, int studentNumber, int passedStudentNumber) {
        this.lesson = lesson;
        this.lessonCod = lessonCod;
        this.unit = unit;
        this.studentNumber = studentNumber;
        this.passedStudentNumber = passedStudentNumber;

    }

    public  personDataCenter (String lesson, int lessonCod, int unit, String classStartTime, JFXToggleButton btnChooseUnit){

        this.lesson = lesson;
        this.lessonCod = lessonCod;
        this.unit = unit;
        this.classStartTime =  classStartTime;
        this.btnChooseUnit =  btnChooseUnit;


    }

    public  personDataCenter(int row,String lesson ,int lessonCod , int unit ,int studentNumber ,String classStartTime ,String classPlace){
        this.row = row;
        this.lesson = lesson;
        this. lessonCod = lessonCod;
        this.unit = unit;
        this.studentNumber = studentNumber;
        this.classStartTime = classStartTime;
        this.classPlace = classPlace;

    }

//    public  person( int row ,String lesson , int lessonCod , int unit , int ){
//
//
//
//
//
//    }

    public personDataCenter(int row,String lastName, String firstName,long studentId,String gender, TextField txtInsert){

        this.row= row;
        this.lastName= lastName;
        this.firstName=firstName;
        this.studentId= studentId;
        this.gender= gender;
        this.txtInsert = txtInsert;

    }

    public person(int row,String lastName,String firstName,long studentId, int numberOfAbsence){
       this.row=row;
       this.lastName=lastName;
       this.firstName=firstName;
       this.studentId=studentId;
       this.numberOfAbsence= numberOfAbsence;

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

    public JFXToggleButton getBtnChooseUnit() {
        return btnChooseUnit;
    }

    public void setBtnChooseUnit(JFXToggleButton btnChooseUnit) {
        this.btnChooseUnit = btnChooseUnit;
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

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public TextField getTxtInsert() {
        return txtInsert;
    }

    public void setTxtInsert(TextField txtInsert) {
        this.txtInsert = txtInsert;
    }


}
