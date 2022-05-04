package users;

public class User {
    protected int id;
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
