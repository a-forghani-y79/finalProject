package sample.DataCenter;


import java.io.*;

// یه کلاس برای اضافه کردن دانشجو های جدید از فایل CSV
// که از سازمان سنجش دریافت شده است
//سازنده یا contractor کلاس فقط آدرس فایل CSV و آدرس فایل باینری مقصد رو خواهد گرفت
// و با متد import کار خود را انجام داده و تمام
public class ImportNewStudent {


    private String CSV_addr;
    private String Bin_addr;
    private NewStudent[] students;



    FileReader fileReader;
    BufferedReader bufferedReader;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;


    private String status;
    private int statusCode = 0;

    ImportNewStudent(String CSV_address, String Binary_address) {
        this.Bin_addr = Binary_address;
        this.CSV_addr = CSV_address;
        setup();


    }


//TODO read information from csv-file , make new student object and write in bin file



    public String getStatus() {
        return this.status;
    }
    public int getStatusCode() {
        return statusCode;
    }


    void setup() {
        try {
            fileReader = new FileReader(CSV_addr);
            bufferedReader = new BufferedReader(fileReader);
            fileOutputStream = new FileOutputStream(Bin_addr);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            status = "successful";
            statusCode = 0;


        } catch (Exception e) {
            if (statusCode == 0) {
                statusCode = 1;
                status += e.getMessage();
            }
        }

    }


}
