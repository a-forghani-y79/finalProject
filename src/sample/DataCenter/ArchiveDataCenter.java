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
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;


    public ArchiveDataCenter() {
        STUDENT_FILE = System.getProperty("user.home") + "\\Desktop\\student.dat";
        File file = new File(STUDENT_FILE);
        if (!(file.exists()))
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("problem in file creating");
                e.printStackTrace();
            }
        MASTER_FILE = System.getProperty("user.home") + "\\Desktop\\master.dat";
        file = new File(MASTER_FILE);
        if (!(file.exists()))
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("problem in file creating");
                e.printStackTrace();
            }
        NEW_STUDENT_FILE = System.getProperty("user.home") + "\\Desktop\\newStudent.dat";
        file = new File(NEW_STUDENT_FILE);
        if (!(file.exists()))
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("problem in file creating");
                e.printStackTrace();
            }
        FIELDS_FILE = System.getProperty("user.home") + "\\Desktop\\fields.dat";
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
    public void writeFields(FieldDataCenter field) {
        ArrayList<FieldDataCenter> list = readAllFields();
        int index = -1;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            for (int i = 0; i < list.size(); i++)
                if (field.getFieldNumber() == list.get(i).getFieldNumber()) {
                    index = i;
                    break;
                }
            if (index > -1) {
                list.remove(index);
            }

        }
        list.add(field);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FIELDS_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public void writeAllFields(ArrayList<FieldDataCenter> fields) {
        System.out.println("At write AllFields " + getClass().getName());
        System.out.println("fields size = " + fields.size());
        ArrayList<FieldDataCenter> list = readAllFields();
        if (list == null)
            list = new ArrayList<>();
        else {
            ArrayList<Long> lessonsConde = new ArrayList<>();
            System.out.println(lessonsConde.size() + " is lesson codes size");
            for (int i = 0; i < fields.size(); i++)
                lessonsConde.add(fields.get(i).getFieldNumber());
            list.removeIf(fieldDataCenter -> lessonsConde.contains(fieldDataCenter.getFieldNumber()));
        }
        list.addAll(fields);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FIELDS_FILE));
            objectOutputStream.writeObject(fields);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
    }

    public void updateAllFields(ArrayList<FieldDataCenter> fields) {
        ArrayList<FieldDataCenter> list = readAllFields();
        ArrayList<FieldDataCenter> NEW = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < fields.size(); j++) {
                if (list.get(i).getFieldNumber() == fields.get(j).getFieldNumber()) {
                    list.remove(i);
                    list.add(fields.get(j));
                }
            }
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FIELDS_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            System.out.println(e.getMessage());
            // e.printStackTrace();
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
            System.out.println(e.getMessage());
            //e.printStackTrace();
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

//    public void writeStudentList(StudentDataCenter[] students) {
//        ArrayList<StudentDataCenter> list = new ArrayList<>();
//        for (int i = 0; i < students.length; i++) {
//            list.add(students[i]);
//        }
//        try {
//            objectOutputStream = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE));
//            objectOutputStream.writeObject(list);
//            objectInputStream.close();
//        } catch (Exception e) {
//            System.out.println("problem in writeAllFields");
//            e.printStackTrace();
//        }
//    }

    public void writeStudent(StudentDataCenter student) {
        ArrayList<StudentDataCenter> list = readAllStudents();
        int index = -1;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getNationalCode() == student.getNationalCode()) {
                    index = i;
                    break;
                }
            if (index > -1) {
                list.remove(index);
            }
        }
        list.add(student);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeAllFields");
            //e.printStackTrace();
            System.out.println(e.getMessage());
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
        int index = -1;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getNationalNumber() == master.getNationalNumber()) {
                    index = i;
                    System.out.println("index founded in writeMaster "+index);
                    break;
                }
        }
        if (index > -1) {
            list.remove(index);
        }

        list.add(master);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(MASTER_FILE));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("problem in writeMaster");
            // e.printStackTrace();
            System.out.println(e.getMessage());
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
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    @SuppressWarnings("unchecked")
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
            //e.printStackTrace();
            System.out.println(e.getMessage());
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