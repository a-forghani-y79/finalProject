package sample.DataCenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentDataCenter implements Serializable {

    private static final long serialVersionUID = -1595287529950289202L;

    private String firstName;
    private String lastName;
    private long nationalCode;
    private long studentNumber;
    private double average;
    private ArrayList<FieldDataCenter> fieldsListForChooseUnit;
    private ArrayList<FieldDataCenter> listAllFields;
    private ArrayList<FieldDataCenter> historyListField;
    private long rate;
    private String field;
    private boolean isDay; //true for roozaneh
    private long fileNumber;
    private long PhoneNumber;
    private Long FatherPhoneNumber;
    private String FatherName;
    private String Faculty;
    private long IDCardNumber;
    private String Address;
    private String SectionEducation;
    private String Condition;
    private String StartSeason;
    private String Nationality;
    private String Course;
    private String DiplomType;
    private String Matrimony;
    private String LocalBorn;
    private int DiplomYear;
    private String UBorn;
    private String Faith;
    private String Religion;
    private String CityBorn;
    private String Email;
    private long ZIPCode;
    private String AreaBorn;
    private long FileNumber1;
    private int BYear;
    private int BMonth;
    private int BDay;
    private double score;
    private String position;
    private HashMap<Long, Integer> absenceReport ;
    private HashMap<Long, Double> gradeReport ;
    public StudentDataCenter(){
        absenceReport = new HashMap<>();
        gradeReport = new HashMap<>();
    }

    public void setAbsenceReport(HashMap<Long, Integer> absenceReport) {
        this.absenceReport = absenceReport;
    }

    public void setGradeReport(HashMap<Long, Double> gradeReport) {
        this.gradeReport = gradeReport;
    }

    public HashMap<Long, Double> getGradeReport() {
        return gradeReport;
    }

    public HashMap<Long, Integer> getAbsenceReport() {
        return absenceReport;
    }

    public void join(long lessonCode) {
        if (!absenceReport.containsKey(lessonCode))
            absenceReport.put(lessonCode, 0);
        if (!gradeReport.containsKey(lessonCode))
            gradeReport.put(lessonCode, 10.0);
    }

    public void left(long lessonCode) {
        absenceReport.remove(lessonCode);
        gradeReport.remove(lessonCode);
    }

    public double getGrade(long lessonCode) {
        return gradeReport.get(lessonCode);
    }

    public void setGrade(long lessonCode, double grade)throws Exception {
        System.out.println("put");
        if (gradeReport.containsKey(lessonCode)){

            gradeReport.put(lessonCode, grade);
        }
    }

    public int getNumberOfAbsence(long lessonCode) {
        return absenceReport.get(lessonCode);
    }

    public void setAbsence(long lessonCode, int numberOfAbsence) {
        if (absenceReport.containsKey(lessonCode))
            absenceReport.put(lessonCode, numberOfAbsence);
    }


    public ArrayList<FieldDataCenter> getHistoryListField() {
        return historyListField;
    }

    public void setHistoryListField(ArrayList<FieldDataCenter> historyListField) {
        this.historyListField = historyListField;
    }

    public ArrayList<FieldDataCenter> getListAllFields() {
        return listAllFields;
    }

    public void setListAllFields(ArrayList<FieldDataCenter> listAllFields) {
        this.listAllFields = listAllFields;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    private int Gender;

    public int getBYear() {
        return BYear;
    }

    public void setBYear(int BYear) {
        this.BYear = BYear;
    }

    public int getBMonth() {
        return BMonth;
    }

    public void setBMonth(int BMonth) {
        this.BMonth = BMonth;
    }

    public int getBDay() {
        return BDay;
    }

    public void setBDay(int BDay) {
        this.BDay = BDay;
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

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Long getFatherPhoneNumber() {
        return FatherPhoneNumber;
    }

    public void setFatherPhoneNumber(Long fatherPhoneNumber) {
        FatherPhoneNumber = fatherPhoneNumber;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public long getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(long IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSectionEducation() {
        return SectionEducation;
    }

    public void setSectionEducation(String sectionEducation) {
        SectionEducation = sectionEducation;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getStartSeason() {
        return StartSeason;
    }

    public void setStartSeason(String startSeason) {
        StartSeason = startSeason;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getDiplomType() {
        return DiplomType;
    }

    public void setDiplomType(String diplomType) {
        DiplomType = diplomType;
    }

    public String getMatrimony() {
        return Matrimony;
    }

    public void setMatrimony(String matrimony) {
        Matrimony = matrimony;
    }

    public String getLocalBorn() {
        return LocalBorn;
    }

    public void setLocalBorn(String localBorn) {
        LocalBorn = localBorn;
    }

    public int getDiplomYear() {
        return DiplomYear;
    }

    public void setDiplomYear(int diplomYear) {
        DiplomYear = diplomYear;
    }

    public String getUBorn() {
        return UBorn;
    }

    public void setUBorn(String UBorn) {
        this.UBorn = UBorn;
    }

    public String getFaith() {
        return Faith;
    }

    public void setFaith(String faith) {
        Faith = faith;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getCityBorn() {
        return CityBorn;
    }

    public void setCityBorn(String cityBorn) {
        CityBorn = cityBorn;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(long ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getAreaBorn() {
        return AreaBorn;
    }

    public void setAreaBorn(String areaBorn) {
        AreaBorn = areaBorn;
    }

    public long getFileNumber1() {
        return FileNumber1;
    }

    public void setFileNumber1(long fileNumber1) {
        FileNumber1 = fileNumber1;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<FieldDataCenter> getFieldsListForChooseUnit() {
        return fieldsListForChooseUnit;
    }

    public void addField(FieldDataCenter field) {
        fieldsListForChooseUnit.add(field);
    }

    public void setFieldsListForChooseUnit(ArrayList<FieldDataCenter> fieldsListForChooseUnit) {
        this.fieldsListForChooseUnit = fieldsListForChooseUnit;
    }
}
