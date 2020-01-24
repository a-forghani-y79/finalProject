package sample.DataCenter;

public class Field {

    private String fieldName;
    private long fieldNumber;
    private int unit;
    private Master master;
    private String classStartTime ;
    private String timeToTakeExam ;
    //TODO زمان امتحان و برگذاری درس اضافه شود

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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
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
