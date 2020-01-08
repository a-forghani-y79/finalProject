package sample.DataCenter;

public class NewStudent {

    //ساختار داده برای دانشجویان جدیدالورود و مطابق لیست دریافتی از سازمان سنجش
    // نام-نام خانوادگی-رتبه -شماره ملی- رشته - روزانه/شبانه - شماره پرونده
    private String firstName;
    private String lastName;
    private long rate;
    private long ID;
    private String field;
    private boolean isDay;
    private long fileNumber;


    public boolean isDay() {
        return isDay;
    }

    public long getFileNumber() {
        return fileNumber;
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

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isDay_night() {
        return isDay;
    }

    public void setDay_night(boolean day_night) {
        this.isDay = day_night;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public void setFileNumber(long fileNumber) {
        this.fileNumber = fileNumber;
    }


}
