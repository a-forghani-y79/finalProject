package sample.DataCenter;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// یه کلاس برای اضافه کردن دانشجو های جدید از فایل CSV
// که از سازمان سنجش دریافت شده است
//سازنده یا contractor کلاس فقط آدرس فایل CSV و آدرس فایل باینری مقصد رو خواهد گرفت
// و با متد import کار خود را انجام داده و تمام
public class ImportNewStudent {


    private String CSV_addr;
    private String Bin_addr;
    private String Bin_name;
    private ArrayList<NewStudent> students;


    FileReader fileReader;
    Scanner scanner;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    NewStudent student;
    String line;
    String[] information;


    private String status;
    private int statusCode = 0;

    public ImportNewStudent(String CSV_address, String Binary_address) {
        this.Bin_addr = Binary_address;
        this.CSV_addr = CSV_address;
        setup();
        compleateList();
        writeListToFile();
        close();


    }

//TODO read information from csv-file , make new student object and write in bin file


    void writeListToFile() {
        NewStudent std ;

        for (int i = 0; i < students.size() ; i++) {
            std=students.get(i);
            try {
                objectOutputStream.writeObject(std);
            } catch (IOException e) {
                if (statusCode==0){
                    status += e.getMessage();
                    statusCode = -3;
                }
            }
        }
    }


    void compleateList() {
        try {
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                information = line.split(",");
                student = new NewStudent();
                student.setFirstName(information[0]);
                student.setLastName(information[1]);
                student.setRate(Long.valueOf(information[2]));
                student.setID(Long.parseLong(information[3]));
                student.setField(information[4]);
                student.setDay_night(information[5].equals("روزانه"));
                student.setFileNumber(Long.parseLong(information[6]));
                students.add(student);
            }


        } catch (Exception e) {
            if (statusCode == 0) {
                status += e.getMessage();
                statusCode = -2;
            }

        }
    }


    public String getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    void setup() {
        try {
            students = new ArrayList<>();
            fileReader = new FileReader(CSV_addr);
            scanner = new Scanner(fileReader);
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

    void close() {
        try {
            fileReader.close();
            fileOutputStream.close();
            objectOutputStream.close();

            statusCode = 0;
        } catch (Exception e) {
            if (statusCode == 0) {
                statusCode = -4;
                status += e.getMessage();
            }
        }
    }


}
