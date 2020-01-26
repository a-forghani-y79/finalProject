package sample.DataCenter;

public class FieldDataCenter {
    @Override
    public String toString() {
        return "FieldDataCenter{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldNumber=" + fieldNumber +
                ", unit=" + unit +
                ", masterName='" + masterName + '\'' +
                ", classStartTime='" + classStartTime + '\'' +
                ", timeToTakeExam='" + timeToTakeExam + '\'' +
                ", score=" + score +
                ", numberOfAbsence=" + numberOfAbsence +
                '}';
    }

    private String fieldName;
    private long fieldNumber;
    private int unit;
    private String masterName;
    private String classStartTime;
    private String timeToTakeExam;
    private double score ;
    private int numberOfAbsence;

    //TODO create place Getter and Setter

    public int getNumberOfAbsence() {
        return numberOfAbsence;
    }

    public void setNumberOfAbsence(int numberOfAbsence) {
        this.numberOfAbsence = numberOfAbsence;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String name) {
        this.fieldName = name;
    }

    public long getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(long fieldNumber) {
        this.fieldNumber = fieldNumber;
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
}
