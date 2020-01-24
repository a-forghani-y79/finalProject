package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.*;
import java.util.ArrayList;

public class ArchiveDataCenter {

    //tedad daneshjoo jadid
    //tedad daneshjoo sabt nam shode


    public ArchiveDataCenter(int year, int mode) {
        STUDENT_FILE = "../Files/y" + year + "/student.dat";
        MASTER_FILE = "../Files/y" + year + "/master.dat";
        MANAGER_FILE = "../Files/y" + year + "/manager.dat";
        NEW_STUDENT_FILE = "../Files/y" + year + "/manager.dat";
        FIELDS_FILE = "../Files/Fields.dat";

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
            case 4:
                loadBinaryFile(FIELDS_FILE);
                break;

        }

    }


    //values of modes
    public static int NEW_STUDENT = 0;
    public static int STUDENT = 1;
    public static int MASTER = 2;
    public static int MANAGER = 3;
    public static int FIELD = 4;


    //addresses
    private String NEW_STUDENT_FILE = "";
    private String STUDENT_FILE = "";
    private String MASTER_FILE = "";
    private String MANAGER_FILE = "";
    private String FIELDS_FILE = "";


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

    public void writeAllFields(FieldDataCenter[] fields) {
        try {
            for (int i = 0; i < fields.length; i++)
                objectOutputStream.writeObject(fields[i]);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");

        }
    }

    public ArrayList<FieldDataCenter> readAllFields() {
        ArrayList<FieldDataCenter> fields = new ArrayList<FieldDataCenter>() {
        };
        FieldDataCenter field = new FieldDataCenter();
        try {
            while (true) {
                field = (FieldDataCenter) objectInputStream.readObject();
                fields.add(field);
            }

        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return fields;
    }

    public StudentDataCenter readStudent(long studentNumber) {
        StudentDataCenter std = new StudentDataCenter();
        boolean flag = true;
        try {
            while (flag) {
                std = (StudentDataCenter) objectInputStream.readObject();
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

    public void writeStudentList(StudentDataCenter[] students) {
        for (int i = 0; i < students.length; i++) {
            try {
                objectOutputStream.writeObject(students[i]);
            } catch (IOException e) {
                erroreMessage += (e.getMessage() + "\n");
            }
        }
    }

    public void writeStudent(StudentDataCenter student) {
        try {
            objectOutputStream.writeObject(student);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }

    public MasterDataCenter readMaster(long personalNumber) {
        MasterDataCenter master = new MasterDataCenter();
        boolean flag = true;
        try {
            while (flag) {
                master = (MasterDataCenter) objectInputStream.readObject();
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

    public void writeMaster(MasterDataCenter master) {
        try {
            objectOutputStream.writeObject(master);
        } catch (IOException e) {
            erroreMessage += (e.getMessage() + "\n");
        }

    }


    public ManagerDataCenter readManager() {
        ManagerDataCenter manager = new ManagerDataCenter();
        return manager;
    }


    public NewStudentDataCenter readNewStudent(long nationalNumber) {
        NewStudentDataCenter std = new NewStudentDataCenter();
        boolean flag = true;
        try {
            while (flag) {
                std = (NewStudentDataCenter) objectInputStream.readObject();
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
    public ArrayList<MasterDataCenter> readAllMasters() {
        ArrayList<MasterDataCenter> list = new ArrayList<MasterDataCenter>() {
        };
        MasterDataCenter std = new MasterDataCenter();
        try {
            while (true) {
                std = (MasterDataCenter) objectInputStream.readObject();
                list.add(std);
            }
        } catch (ClassNotFoundException | IOException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
        return list;
    }

    public void writeAllMaster(MasterDataCenter[] masters) {
        try {
            for (int i = 0; i < masters.length; i++) {
                objectOutputStream.writeObject(masters[i]);
            }
        } catch (IOException e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }

    //read All Students

    public ArrayList<StudentDataCenter> readAllStudents() {
        ArrayList<StudentDataCenter> list = new ArrayList<StudentDataCenter>() {
        };
        StudentDataCenter std = new StudentDataCenter();

        try {
            while (true) {
                std = (StudentDataCenter) objectInputStream.readObject();
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
            fileOutputStream = new FileOutputStream(dist, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (Exception e) {
            erroreMessage += (e.getMessage() + "\n");
        }
    }





}
