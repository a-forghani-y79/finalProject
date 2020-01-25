package sample.DataCenter;

//this is a tool for up/downloading data to/from file
//Every communications with Files should  be done by THIS class

import java.io.*;
import java.util.ArrayList;

public class ArchiveDataCenter {

    private String STUDENT_FILE;
    private String MASTER_FILE;
    private String NEW_STUDENT_FILE;
    private String FIELDS_FILE;

    public ArchiveDataCenter() {
        STUDENT_FILE = "C:\\Users\\Home\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\student.dat";
        MASTER_FILE = "C:\\Users\\Home\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\master.dat";
        NEW_STUDENT_FILE = "C:\\Users\\Home\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\newStudent.dat";
        FIELDS_FILE = "C:\\Users\\Home\\IdeaProjects\\finalProject\\src\\sample\\Files\\y98\\fields.dat";
    }

//TODO error code AC

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

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
        return new ManagerDataCenter();
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
        ArrayList<NewStudentDataCenter> list = new ArrayList<NewStudentDataCenter>();
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
        ArrayList<MasterDataCenter> list = new ArrayList<MasterDataCenter>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(MASTER_FILE));
            list = (ArrayList<MasterDataCenter>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("problem in readAllMasters");
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<StudentDataCenter> readAllStudents() {
        ArrayList<StudentDataCenter> list = new ArrayList<StudentDataCenter>();
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

    public boolean removeMaster(long personalNumber) {
        boolean flag = false;
        ArrayList<MasterDataCenter> list = readAllMasters();
        for (MasterDataCenter master : list
        ) {
            if (master.getPersonalNumber() == personalNumber) {
                flag = list.remove(master);
                break;
            }
        }
        return flag;
    }

    public boolean removeField(long fieldNumber) {
        ArrayList<FieldDataCenter> list = readAllFields();
        boolean flag = false;
        for (FieldDataCenter field : list) {
            if (field.getFieldNumber() == fieldNumber){
                flag = list.remove(field);
                break;
            }
        }
        return flag;
    }
}