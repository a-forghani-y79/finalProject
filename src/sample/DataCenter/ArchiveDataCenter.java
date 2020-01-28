package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.util.ArrayList;

public class ArchiveDataCenter {

    private String STUDENT_FILE;
    private String MASTER_FILE;
    private String NEW_STUDENT_FILE;
    private String FIELDS_FILE;
    private File file;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;


    public ArchiveDataCenter() {
        STUDENT_FILE = "C:\\Users\\Hossein\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\student.dat";
        file = new File(STUDENT_FILE);
        if (!(file.exists()))
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("problem in file creating");
            e.printStackTrace();
        }
        MASTER_FILE = "C:\\Users\\Hossein\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\master.dat";
        file = new File(MASTER_FILE);
        if (!(file.exists()))
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("problem in file creating");
            e.printStackTrace();
        }
        NEW_STUDENT_FILE = "C:\\Users\\Hossein\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\newStudent.dat";
        file = new File(NEW_STUDENT_FILE);
        if (!(file.exists()))
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("problem in file creating");
            e.printStackTrace();
        }
        FIELDS_FILE = "C:\\Users\\Hossein\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\fields.dat";
        file = new File(FIELDS_FILE);
        if (!(file.exists()))
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("problem in file creating");
            e.printStackTrace();
        }
    }

//TODO error code AC
    public void writeAllFields(FieldDataCenter[] fields) {
        ArrayList<FieldDataCenter> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            list.add(fields[i]);
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FIELDS_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            e.printStackTrace();
        }
    }

    public ArrayList<FieldDataCenter> readAllFields() {
        ArrayList<FieldDataCenter> fields = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(FIELDS_FILE));
            fields = (ArrayList<FieldDataCenter>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in readAllFields");
            e.printStackTrace();
        }
        return fields;
    }

    public StudentDataCenter readStudent(long studentNumber) {
        StudentDataCenter std = null;
        ArrayList<StudentDataCenter> list = readAllStudents();
        for (int i = 0; i < list.size(); i++) {
            if (studentNumber == list.get(i).getStudentNumber()) {
                std = list.get(i);
                break;
            }
        }
        return std;
    }

    public void writeStudentList(StudentDataCenter[] students) {
        ArrayList<StudentDataCenter> list = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            list.add(students[i]);
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE));
            objectOutputStream.writeObject(list);
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            e.printStackTrace();
        }
    }

    public void writeStudent(StudentDataCenter student) {
        ArrayList<StudentDataCenter> list = readAllStudents();
        list.add(student);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            e.printStackTrace();
        }
    }

    public MasterDataCenter readMaster(long personalNumber) {
        ArrayList<MasterDataCenter> list = readAllMasters();
        MasterDataCenter master = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPersonalNumber() == personalNumber) {
                master = list.get(i);
                break;
            }
        }
        return master;
    }

    public void writeMaster(MasterDataCenter master) {
        ArrayList<MasterDataCenter> list = readAllMasters();
        list.add(master);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(MASTER_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeMaster");
            e.printStackTrace();
        }
    }

    public ManagerDataCenter readManager() {
        ManagerDataCenter managerDataCenter = new ManagerDataCenter();
        return managerDataCenter;
    }

    public NewStudentDataCenter readNewStudent(long nationalNumber) {
        NewStudentDataCenter std = null;
        ArrayList<NewStudentDataCenter> list = readAllNewStudents();
        for (NewStudentDataCenter student : list) {
            if (student.getID() == nationalNumber) {
                std = student;
                break;
            }
        }
        return std;
    }

    public ArrayList<NewStudentDataCenter> readAllNewStudents() {
        ArrayList<NewStudentDataCenter> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(NEW_STUDENT_FILE));
            list = (ArrayList<NewStudentDataCenter>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in readAllNewStudent");
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<MasterDataCenter> readAllMasters() {
        ArrayList<MasterDataCenter> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(MASTER_FILE));
            list = (ArrayList<MasterDataCenter>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in readAllMasters");
        }
        return list;
    }

    public ArrayList<StudentDataCenter> readAllStudents() {
        ArrayList<StudentDataCenter> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(STUDENT_FILE));
            list = (ArrayList<StudentDataCenter>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in readAllStudents");
            e.printStackTrace();
        }
        return list;
    }

    public FieldDataCenter readField(long lessonCode) {
        FieldDataCenter field = null;
        ArrayList<FieldDataCenter> list = readAllFields();
        for (FieldDataCenter fieldDataCenter : list) {
            if (fieldDataCenter.getFieldNumber() == lessonCode) {
                field = fieldDataCenter;
                break;
            }
        }
        return field;
    }
}