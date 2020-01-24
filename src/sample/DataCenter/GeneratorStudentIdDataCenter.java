package sample.DataCenter;

import java.util.ArrayList;

public class GeneratorStudentIdDataCenter {
    private int yearNumber = 0;
    private int numberOfStudents = 0;
    private int numberOfManagers = 0;
    private int numberOfMasters = 0;

    private int NUMBERSTUDENT = 536;
    private int NUMBERMASTER = 546;
    private int NUMBERMANAGER = 556;

    public GeneratorStudentIdDataCenter() {
        ArchiveDataCenter archive = new ArchiveDataCenter(98, ArchiveDataCenter.STUDENT);

    }

    ArchiveDataCenter archive = new ArchiveDataCenter(98, ArchiveDataCenter.STUDENT);

    public int getYearNumber() {


        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        yearNumber = yearNumber;
    }

    public int getNumberOfStudent() {
        return numberOfStudents;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudents = numberOfStudent;
    }

    public int getNUMBER() {
        return NUMBERSTUDENT;
    }

    public void setNUMBER(int NUMBER) {
        this.NUMBERSTUDENT = NUMBER;
    }

    //Creat ID For Student
    public long creatIdStudent() {
        ArrayList<StudentDataCenter> students = new ArrayList<StudentDataCenter>();
        students.addAll(archive.readAllStudents());
        numberOfStudents = students.size();
        long resultNumber = 0;
        String str = String.valueOf(numberOfStudents);
        if (str.length() == 1)
            str = "000" + str;
        else if (str.length() == 2)
            str = "00" + str;
        else if (str.length() == 3)
            str = "0" + str;

        resultNumber = (long) ((yearNumber * Math.pow(10, 7)) + (NUMBERSTUDENT * Math.pow(10, 4)) + numberOfStudents);

        return resultNumber;
    }

    //Creat ID For Master
    public long createIdMaster() {
        ArrayList<MasterDataCenter> masters = new ArrayList<MasterDataCenter>();
        masters.addAll(archive.readAllMasters());
        numberOfMasters = masters.size();
        long resultNumber = 0;
        String str = String.valueOf(numberOfMasters);
        if (str.length() == 1)
            str = "000" + str;
        else if (str.length() == 2)
            str = "00" + str;
        else if (str.length() == 3)
            str = "0" + str;

        resultNumber = (long) ((yearNumber * Math.pow(10, 7)) + (NUMBERMASTER * Math.pow(10, 4)) + numberOfMasters);

        return resultNumber;
    }

}
