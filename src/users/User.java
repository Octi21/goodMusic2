package users;

public class User {
    protected static int var = 0;

    protected  int id = 0;
    protected String fName, lName;
    protected String email, phone;
    protected String username, password;


//    {
//        var += 1;
//    }
    public User(String fName, String lName, String email, String phone, String username, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        var += 1;
        this.id = var;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean login(String username, String password)
    {
        if (this.username.equals(username))
            if(this.password.equals(password))
                return true;
        return false;
    }

}
