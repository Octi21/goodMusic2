package users;

public class User {
    protected static int var = 0;

    protected  int id = 0;
    protected String fName, lName;
    protected String email, phone;
    protected String username, password;


    public User(int id,String fName, String lName, String email, String phone, String username, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User(String fName, String lName, String email, String phone, String username, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;


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

    public static int getVar() {
        return var;
    }

    public static void setVar(int var) {
        User.var = var;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String username, String password)
    {
        if (this.username.equals(username))
            if(this.password.equals(password))
                return true;
        return false;
    }

}
