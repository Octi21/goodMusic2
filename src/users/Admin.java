package users;

public class Admin extends User{
    protected static int aux = 0;

    protected int update;

    public Admin(int id,String fName, String lName, String email, String phone, String username, String password,int update) {
        super(id,fName, lName, email, phone, username, password);
        this.update = update;
    }

    public Admin(String fName, String lName, String email, String phone, String username, String password,int update) {
        super(fName, lName,  email,  phone,  username,  password);
        aux +=1;
        this.id = aux;

        this.update = update;
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

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Admin.aux = aux;
    }
}
