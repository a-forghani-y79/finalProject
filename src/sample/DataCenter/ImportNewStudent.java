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
    private ArrayList<NewStudent> students;


    private FileReader fileReader;
    private Scanner scanner;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private File file;


    private String status;
    private int statusCode = 0;


    public ImportNewStudent(String CSV_address,int year) {
        file = new File("./src/sample/Files/y"+year+"");
        file.mkdir();
        this.Bin_addr = ".\\src\\sample\\Files\\y"+year+"\\newStudent.dat";
        this.CSV_addr = CSV_address;
        setup();
        compleateList();
        writeListToFile();
        close();


    }


    private void writeListToFile() {
        NewStudent std = new NewStudent();

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


    private void compleateList() {
        try {
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] information = line.split(",");
                NewStudent student = new NewStudent();
                student.setFirstName(information[0]);
                student.setLastName(information[1]);
                student.setRate(Long.parseLong(information[2]));
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
