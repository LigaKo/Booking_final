public class User {
    private int userID;
    private int password;


    public User() {

    }

    public boolean login() {
        return (getUserID() == 1 && getPassword() == 1) ||
                (getUserID() == 2 && getPassword() == 2) ||
                (getUserID() == 3 && getPassword() == 3);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}