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
    private long lessonCode;
    private int unit;
    private int studentNumber;
    private int passedStudent;
    private ArrayList<FieldDataCenter>  masterField;

    public ArrayList<FieldDataCenter> getMasField() {
        return masterField;
    }

    public void setMasField(ArrayList<FieldDataCenter> masField) {
        this.masterField = masField;
    }

    public long getLessonCode() {
        return lessonCode;
    }

    public void setLessonCode(long lessonCode) {
        this.lessonCode = lessonCode;
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
