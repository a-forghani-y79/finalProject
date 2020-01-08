package sample.DataCenter;

public class NewStudent {

    //ساختار داده برای دانشجویان جدیدالورود و مطابق لیست دریافتی از سازمان سنجش
    //نام-نام خانوادگی-رتبه -شماره ملی- رشته - روزانه/شبانه
    private String firstName;
    private String lastName;
    private long  rate;
    private long ID;
    private String field;
    private boolean isDay;

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



}
