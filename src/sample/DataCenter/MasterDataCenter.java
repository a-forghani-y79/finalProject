package sample.DataCenter;

import java.io.Serializable;
import java.util.ArrayList;

public class MasterDataCenter implements Serializable {


    private String firstName;
    private String lastName;
    private long nationalNumber;
    private long  personalNumber;
    private int gender;
    private String lesson;
    private int lessonCode;
    private int unit;
    private int studentNumber;
    private int passedStudent;

    public ArrayList<FieldDataCenter> getMasField() {
        return masField;
    }

    public void setMasField(ArrayList<FieldDataCenter> masField) {
        this.masField = masField;
    }

    private ArrayList<FieldDataCenter>  masField;






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

    public long getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(long nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getLessonCode() {
        return lessonCode;
    }

    public void setLessonCode(int lessonCode) {
        this.lessonCode = lessonCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getPassedStudent() {
        return passedStudent;
    }

    public void setPassedStudent(int passedStudent) {
        this.passedStudent = passedStudent;
    }
}
