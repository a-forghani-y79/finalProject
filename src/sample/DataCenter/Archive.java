package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.*;
import java.util.ArrayList;

public class Archive {
    //tedad daneshjoo jadid
    //tedad daneshjoo sabt nam shode


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

    public int readNumberOfStudent() {
        int numberOfStudent = 0;

        return numberOfStudent;
    }

    public Student readStudent(long studentNumber) {
        Student std = new Student();
        boolean flag = true;
        try {
            while (flag) {
                std = (Student) objectInputStream.readObject();
                if (std.getStudentNumber() == studentNumber)
                    flag = false;
            }

        } catch (EOFException e) {
            erroreMessage += (e.getMessage() + "\n");
            if (flag) {
                erroreMessage += ("student not found\n");
                std = null;
            }
        } catch (IOException | ClassNotFoundException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return std;

    }

   public void writeStudentList(Student [] students) {
        for (int i = 0 ; i<students.length;i++) {
            try {
                objectOutputStream.writeObject(students[i]);
            }catch (IOException e){
                erroreMessage+=(e.getMessage()+"\n");
            }
        }
    }

    public void writeStudent(Student student) {
        try {
            objectOutputStream.writeObject(student);
        } catch (Exception e) {
           erroreMessage+=(e.getMessage()+"\n");
        }
    }

    public Master readMaster(long personalNumber) {
        Master master = new Master();
        boolean flag = true;
        try {
            while (flag) {
                master = (Master) objectInputStream.readObject();
                if (master.getPersonalNumber() == personalNumber)
                    flag = false;
            }

        } catch (EOFException e) {
            erroreMessage += (e.getMessage() + "\n");
            if (flag) {
                erroreMessage += ("student not found\n");
                master = null;
            }
        } catch (IOException | ClassNotFoundException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return master;
    }

    public void writeMaster(Master master) {
        try {
            objectOutputStream.writeObject(master);
        }catch (IOException e ) {
            erroreMessage += (e.getMessage()+"\n");
        }

    }


   public Manager readManager() {
    Manager manager = new Manager();
    return manager;
    }



    public NewStudent readNewStudent(long nationalNumber) {
        NewStudent std = new NewStudent();
        boolean flag = true;
        try {
            while (flag) {
                std = (NewStudent) objectInputStream.readObject();
                if (std.getID() == nationalNumber)
                    flag = false;
            }

        } catch (EOFException e) {
            erroreMessage += (e.getMessage() + "\n");
            if (flag) {
                erroreMessage += ("student not found\n");
                std = null;
            }
        } catch (IOException | ClassNotFoundException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return std;
    }


    //    void readAllMasters() {
//    }
    //read All Masters
     public ArrayList<Master> readAllMasters() {
        ArrayList<Master> list = new ArrayList<Master>(){};
        Master std = new Master();
        try {
            while (true) {
                std = (Master)objectInputStream.readObject();
                list.add(std);
            }
        } catch (ClassNotFoundException | IOException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return list;
    }
    public void writeAllMaster(Master[] masters){
        try {
            for (int i = 0; i<masters.length;i++){
                objectOutputStream.writeObject(masters[i]);
            }
        }catch (IOException e){
            erroreMessage += (e.getMessage()+"\n");
        }
    }

    //read All Students

   public ArrayList<Student> readAllStudents() {
        ArrayList<Student> list = new ArrayList<Student>() {
        };
        Student std = new Student();

        try {
            while (true) {
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
            fileOutputStream = new FileOutputStream(dist,true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }


    public static void main(String[] args) {


    }


}
