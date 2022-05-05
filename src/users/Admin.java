package users;

public class Admin extends User{
    protected static int update =0;

    public Admin(String fName, String lName, String email, String phone, String username, String password) {
        super(fName, lName, email, phone, username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uppdate='" + update + '\'' +
                '}';
    }

    public static int getUpdate() {
        return update;
    }

    public static void setUpdate(int update) {
        Admin.update = update;
    }
}
