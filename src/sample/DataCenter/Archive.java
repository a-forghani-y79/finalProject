package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archive {

    public Archive(int year) {
        this.year = year;

    }

    //addresses
    private int year;
    String STUDENT_FILE = "";
    String MASTER_FILE = "";
    String AGENT_FILE = "";


    private String erroreMessage = "";


    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;


    void readStudent() {
    }

    void writeStudent() {
    }

    void readMaster() {
    }

    void writeMaster() {
    }


    void readManager() {
    }

    void writeManager() {
    }

    void readNewStudent(long id) {
    }

    void writeNewStudent() {
    }
    void readAllMasters(){}
    void readAllStudents(){}


    boolean isAllowed() {
        if (erroreMessage.length() == 0)
            return true;
        else
            return false;
    }

    String reportErrores() {
        return erroreMessage;
    }

    private void createBinaryFile(String dist) {
        try {
            fileOutputStream = new FileOutputStream(dist);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }

    private void loadBinaryFile(String dist) {
        try {
            fileInputStream = new FileInputStream(dist);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }


    public static void main(String[] args) {


    }


}
