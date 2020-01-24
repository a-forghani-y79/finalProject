package sample.DataCenter;

public class FieldDataCenter {

    private String fieldName;
    private long fieldNumber;
    private int unit;
    private String masterName;
    private String classStartTime;
    private String timeToTakeExam;

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }



    public String getName() {
        return fieldName;
    }

    public void setName(String name) {
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
