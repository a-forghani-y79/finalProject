package sample.DataCenter;

public class ManagerDataCenter {
    private String firstName;
    private String lastName;
    private String userNameHash;
    private String passwordNameHash;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserNameHash() {
        return userNameHash;
    }

    public void setUserNameHash(String userNameHash) {
        this.userNameHash = userNameHash;
    }

    public String getPasswordNameHash() {
        return passwordNameHash;
    }

    public void setPasswordNameHash(String passwordNameHash) {
        this.passwordNameHash = passwordNameHash;
    }



    public ManagerDataCenter() {
        firstName = "علی";
        lastName = "پاکزاد";
        userNameHash = "ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f";
        passwordNameHash = "e24df920078c3dd4e7e8d2442f00e5c9ab2a231bb3918d65cc50906e49ecaef4";

    }
}
