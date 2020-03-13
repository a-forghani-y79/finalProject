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
        userNameHash = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
        passwordNameHash = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";

    }
}
