package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.*;
import java.util.ArrayList;

public class Archive {


    public Archive(int year, int mode) {
        switch (mode) {
            case 0:
                loadBinaryFile(NEW_STUDENT_FILE);
                break;
            case 1:
                loadBinaryFile(STUDENT_FILE);
                break;
            case 2:
                loadBinaryFile(MASTER_FILE);
                break;
            case 3:
                loadBinaryFile(MANAGER_FILE);
                break;
        }
        STUDENT_FILE = "../Files/y" + year + "/student.dat";
        MASTER_FILE = "../Files/y" + year + "/master.dat";
        MANAGER_FILE = "../Files/y" + year + "/manager.dat";
        NEW_STUDENT_FILE = "../Files/y" + year + "/manager.dat";
    }


    //values of modes
   public static int NEW_STUDENT = 0;
    public static int STUDENT = 1;
    public static int MASTER = 2;
    public static int MANAGER = 3;


    //addresses
    private String NEW_STUDENT_FILE = "";
    private String STUDENT_FILE = "";
    private String MASTER_FILE = "";
    private String MANAGER_FILE = "";


    private String erroreMessage = "";


    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    private File file;


    void readStudent() {
    }
    void writeStudentList(){

    }

    public void writeStudent() {
        String name = "" ;


    }

    void readMaster() {
    }

    void writeMaster() {
    }


    void readManager() {
    }

    void writeManager() {
    }

    public NewStudent readNewStudent(long nationalNumber)  {
        NewStudent std = new NewStudent();
        boolean flag = true;
        try {
            while (flag){
                objectInputStream.readObject();
                if (std.getID()==nationalNumber)
                    flag = false;
            }

        }catch (EOFException e){
            erroreMessage += (e.getMessage() + "\n");
            if (flag) {
                erroreMessage += ("student not found\n");
                std = null;
            }
        }catch (IOException | ClassNotFoundException e){
            erroreMessage += (e.getMessage() + "\n");
        }
        return std;
    }



    void readAllMasters() {
    }

    ArrayList<Student> readAllStudents()  {
        ArrayList<Student> list = new ArrayList<Student>() {};
        Student std = new Student();

            try {
                while(true) {
                    std = (Student) objectInputStream.readObject();
                    list.add(std);
                }
            } catch (ClassNotFoundException | IOException e) {
                erroreMessage += (e.getMessage() + "\n");
            }
        return list;
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
