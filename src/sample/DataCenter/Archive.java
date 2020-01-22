package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archive {

    //addresses
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

    public void writeStudent() {
        String name = "" ;


    }

    void readMaster() {
    }

    void writeMaster() {
    }


    void readAgent() {
    }

    void writeAgent() {
    }


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
