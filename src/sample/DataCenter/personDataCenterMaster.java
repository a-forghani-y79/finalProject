package sample.DataCenter;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.TextField;

public class personDataCenterMaster {

    //history Table or weeklyTable
    private String teachedLessonHistory;
    private long teachedLessonCodeHistory;
    private int teachedLessonUnitHistory;
    private int numberOfStudentTeachedLesson;
    private int numberOfPassedStudentTeachedLesson;
    // newWeekTable // barnameye roozaneye ostad
    private int rowNewWeeklyTable;
    private String masterChosedLesson;
    private long masterChosedLessonCode;
    private int masterChosedLessonUnit;
    private int numberOfStudentMasterChosedLesson;
    private String classTartTimeMasterChosedLesson;
    //AddFieldTable
    private String presentedLesson;
    private long presentedLessonCode;
    private int presentedLessonUnit;
    private String presentedLessonStartTime;
    private JFXToggleButton addPresentedLessonToggleButton;
    //insertGradeTable
    private int rowInsertGradeTable;
    private String studentLastName;
    private String studentFirstName;
    private long studentId;
    private int studentGender;
    private TextField txtInsertGradeForMaster;
    //present and absence
    private int rowPresentAbsence;
    private TextField txtInsertAbsenceNumberOfStudent;


    //history Table or weeklyTable
    public personDataCenterMaster(String lesson, long lessonCode, int unit, int studentNumber, int passedStudentNumber) {
        this.teachedLessonHistory = lesson;
        this.teachedLessonCodeHistory = lessonCode;
        this.teachedLessonUnitHistory = unit;
        this.numberOfStudentTeachedLesson = studentNumber;
        this.numberOfPassedStudentTeachedLesson = passedStudentNumber;
    }

    // newWeekTable // barnameye roozaneye ostad
    public personDataCenterMaster(int rowNewWeeklyTable, String masterChosedLesson, long masterChosedLessonCode, int masterChosedLessonUnit, int numberOfStudentMasterChosedLesson, String classTartTimeMasterChosedLesson, String s) {
        this.rowNewWeeklyTable = rowNewWeeklyTable;
        this.masterChosedLesson = masterChosedLesson;
        this.masterChosedLessonCode = masterChosedLessonCode;
        this.masterChosedLessonUnit = masterChosedLessonUnit;
        this.numberOfStudentMasterChosedLesson = numberOfStudentMasterChosedLesson;
        this.classTartTimeMasterChosedLesson = classTartTimeMasterChosedLesson;


    }


    //AddFieldTable
    public personDataCenterMaster(String lesson,long lessonCode,int unit,String classStartTime,JFXToggleButton btnAddLesson) {
        this.presentedLesson = lesson;
        this.presentedLessonCode = lessonCode;
        this.presentedLessonUnit = unit;
        this.presentedLessonStartTime = classStartTime;
        this.addPresentedLessonToggleButton = btnAddLesson;
    }

    //insertGradeTable
    public personDataCenterMaster(int row , String lastName, String firstName, long studentId, int studentGender, JFXTextField txtInsertGrade) {
        this.rowInsertGradeTable = row;
        this.studentLastName = lastName;
        this.studentFirstName = firstName;
        this.studentId = studentId;
        this.studentGender = studentGender;
        this.txtInsertGradeForMaster = txtInsertGrade;


    }

    //present and absence
    public personDataCenterMaster(int row , String lastName, String firstName, long studentId,JFXTextField txtInsertAbsence) {
        this.rowPresentAbsence = row;
        this.studentLastName = lastName;
        this.studentFirstName = firstName;
        this.studentId = studentId;
        this.txtInsertAbsenceNumberOfStudent = txtInsertAbsence;
    }



// getters and setters

    public String getTeachedLessonHistory() {
        return teachedLessonHistory;
    }

    public void setTeachedLessonHistory(String teachedLessonHistory) {
        this.teachedLessonHistory = teachedLessonHistory;
    }

    public long getTeachedLessonCodeHistory() {
        return teachedLessonCodeHistory;
    }

    public void setTeachedLessonCodeHistory(long teachedLessonCodeHistory) {
        this.teachedLessonCodeHistory = teachedLessonCodeHistory;
    }

    public int getTeachedLessonUnitHistory() {
        return teachedLessonUnitHistory;
    }

    public void setTeachedLessonUnitHistory(int teachedLessonUnitHistory) {
        this.teachedLessonUnitHistory = teachedLessonUnitHistory;
    }

    public int getNumberOfStudentTeachedLesson() {
        return numberOfStudentTeachedLesson;
    }

    public void setNumberOfStudentTeachedLesson(int numberOfStudentTeachedLesson) {
        this.numberOfStudentTeachedLesson = numberOfStudentTeachedLesson;
    }

    public int getNumberOfPassedStudentTeachedLesson() {
        return numberOfPassedStudentTeachedLesson;
    }

    public void setNumberOfPassedStudentTeachedLesson(int numberOfPassedStudentTeachedLesson) {
        this.numberOfPassedStudentTeachedLesson = numberOfPassedStudentTeachedLesson;
    }
//
    public int getRowWeeklyTable() {
        return rowNewWeeklyTable;
    }

    public void setRowWeeklyTable(int rowWeeklyTable) {
        this.rowNewWeeklyTable = rowWeeklyTable;
    }
//
    public int getRowInsertGradeTable() {
        return rowInsertGradeTable;
    }

    public void setRowInsertGradeTable(int rowInsertGradeTable) {
        this.rowInsertGradeTable = rowInsertGradeTable;
    }
//
    public int getRowPresentAbsence() {
        return rowPresentAbsence;
    }

    public void setRowPresentAbsence(int rowPresentAbsence) {
        this.rowPresentAbsence = rowPresentAbsence;
    }

    public String getMasterChosedLesson() {
        return masterChosedLesson;
    }

    public void setMasterChosedLesson(String masterChosedLesson) {
        this.masterChosedLesson = masterChosedLesson;
    }

    public long getMasterChosedLessonCode() {
        return masterChosedLessonCode;
    }

    public void setMasterChosedLessonCode(long masterChosedLessonCode) {
        this.masterChosedLessonCode = masterChosedLessonCode;
    }

    public int getMasterChosedLessonUnit() {
        return masterChosedLessonUnit;
    }

    public void setMasterChosedLessonUnit(int masterChosedLessonUnit) {
        this.masterChosedLessonUnit = masterChosedLessonUnit;
    }

    public int getNumberOfStudentMasterChosedLesson() {
        return numberOfStudentMasterChosedLesson;
    }

    public void setNumberOfStudentMasterChosedLesson(int numberOfStudentMasterChosedLesson) {
        this.numberOfStudentMasterChosedLesson = numberOfStudentMasterChosedLesson;
    }

    public String getClassTartTimeMasterChosedLesson() {
        return classTartTimeMasterChosedLesson;
    }

    public void setClassTartTimeMasterChosedLesson(String classTartTimeMasterChosedLesson) {
        this.classTartTimeMasterChosedLesson = classTartTimeMasterChosedLesson;
    }

    public String getPresentedLesson() {
        return presentedLesson;
    }

    public void setPresentedLesson(String presentedLesson) {
        this.presentedLesson = presentedLesson;
    }

    public long getPresentedLessonCode() {
        return presentedLessonCode;
    }

    public void setPresentedLessonCode(long presentedLessonCode) {
        this.presentedLessonCode = presentedLessonCode;
    }

    public int getPresentedLessonUnit() {
        return presentedLessonUnit;
    }

    public void setPresentedLessonUnit(int presentedLessonUnit) {
        this.presentedLessonUnit = presentedLessonUnit;
    }

    public String getPresentedLessonStartTime() {
        return presentedLessonStartTime;
    }

    public void setPresentedLessonStartTime(String presentedLessonStartTime) {
        this.presentedLessonStartTime = presentedLessonStartTime;
    }

    public JFXToggleButton getAddPresentedLessonToggleButton() {
        return addPresentedLessonToggleButton;
    }

    public void setAddPresentedLessonToggleButton(JFXToggleButton addPresentedLessonToggleButton) {
        this.addPresentedLessonToggleButton = addPresentedLessonToggleButton;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(int studentGender) {
        this.studentGender = studentGender;
    }

    public TextField getTxtInsertGradeForMaster() {
        return txtInsertGradeForMaster;
    }

    public void setTxtInsertGradeForMaster(TextField txtInsertGradeForMaster) {
        this.txtInsertGradeForMaster = txtInsertGradeForMaster;
    }

    public TextField getTxtInsertAbsenceNumberOfStudent() {
        return txtInsertAbsenceNumberOfStudent;
    }

    public void setTxtInsertAbsenceNumberOfStudent(TextField txtInsertAbsenceNumberOfStudent) {
        this.txtInsertAbsenceNumberOfStudent = txtInsertAbsenceNumberOfStudent;
    }


}
