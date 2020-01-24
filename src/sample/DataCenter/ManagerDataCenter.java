package sample.DataCenter;

public class ManagerDataCenter {
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

    private String firstName;
    private String lastName;
    private String userNameHash;
    private String passwordNameHash;

    public ManagerDataCenter() {
        firstName = "علی";
        lastName = "پاکزاد";
        userNameHash = "7689fdb8267556981974c94fab9d7a77ba62efa8605329264e0c39bbfc486ce2";
        passwordNameHash = "2a3db694a6023717b1fb447cc4e4d3d1af10ac79f97e08203ee5c688d58bfcab";

    }
}
