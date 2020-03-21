package sample.TestTools;

import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.MasterDataCenter;
import sample.DataCenter.NewStudentDataCenter;
import sample.DataCenter.StudentDataCenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Printer {
    static int i = 6;

    public static void main(String[] args) {
        System.out.println("FinalProject Printer");
        System.out.println(i);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<String>> list;

        System.out.println("Select File for Printing:\n\t[1].fields.dat\n\t[2].master.dat\n\t[3].student.dat\n\t[4].newStudent.dat");
        Scanner sc = new Scanner(System.in);

        String dist = "";
        int selection = sc.nextInt();
        switch (selection) {
            case 1:
                dist = System.getProperty("user.home") + "\\Desktop\\fields.dat";
                break;
            case 2:
                dist =System.getProperty("user.home") + "\\Desktop\\master.dat";
                break;
            case 3:
                dist = System.getProperty("user.home") + "\\Desktop\\student.dat";// address of student
                break;
            case 4:
                dist = System.getProperty("user.home") + "\\Desktop\\newStudent.dat"; //address of newStudents
                break;
            default:
                System.out.println("invalid selection");
                System.exit(-1);
        }
        try {
            File file = new File(dist);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            switch (selection) {
                case 1:
                    ArrayList <FieldDataCenter> listF = new ArrayList();
                    listF = (ArrayList <FieldDataCenter>) objectInputStream.readObject();

                 for (FieldDataCenter fieldDataCenter : listF
                    ) {
                        System.out.println("Name: ");
                        System.out.println("\t"+fieldDataCenter.getFieldName());
                        System.out.println("Code: ");
                        System.out.println("\t"+fieldDataCenter.getFieldNumber());
                        System.out.println("Class Time: ");
                        System.out.println("\t"+fieldDataCenter.getClassStartTime());
                     System.out.println(fieldDataCenter.getMasterName());
                        System.out.println("\\**********//");
                    }

                    break;
                case 2:
                    ArrayList <MasterDataCenter> listM = new ArrayList();
                    listM = (ArrayList <MasterDataCenter>) objectInputStream.readObject();
                    for (MasterDataCenter master : listM
                    ) {
                        System.out.println("Name: ");
                        System.out.println("\t"+master.getFirstName() + " " + master.getLastName());
                        System.out.println("Personal Code: ");
                        System.out.println("\t"+master.getPersonalNumber());
                        System.out.println("National Code: ");
                        System.out.println("\t"+master.getNationalNumber());
                        System.out.println("Fields");
                        try {


                        for (FieldDataCenter field:
                             master.getMasField()) {
                            System.out.println(field.getFieldName());
                        }
                    }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\\**********//");

                    }

                    break;
                case 3:
                    ArrayList <StudentDataCenter> listS = new ArrayList();
                    listS = (ArrayList <StudentDataCenter>) objectInputStream.readObject();
                    for (StudentDataCenter std : listS
                    ) {

                        System.out.println("Name:");
                        System.out.println("\t"+std.getFirstName()+" "+std.getLastName());
                        System.out.println("Student Number: ");
                        System.out.println("\t"+std.getStudentNumber());
                        System.out.println("National Number: ");
                        System.out.println("\t"+std.getNationalCode());
                        System.out.println("\\**********//");
                    }

                    break;
                case 4:

                    ArrayList <NewStudentDataCenter> listN = new ArrayList();
                    listN = (ArrayList<NewStudentDataCenter>)objectInputStream.readObject();
                    for (NewStudentDataCenter std:listN
                         ) {
                        System.out.println("Name:");
                        System.out.println("\t"+std.getFirstName()+" "+std.getLastName());
                        System.out.println("National Number: ");
                        System.out.println("\t"+std.getID());
                        System.out.println("File Number: ");
                        System.out.println("\t"+std.getFileNumber());
                        System.out.println("\\**********//");
                    }

                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
