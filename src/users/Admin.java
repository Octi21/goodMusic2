package users;

import start.Card;

public class Admin extends User{
    protected static int aux = 0;

    protected static int update =0;

    public Admin(int id,String fName, String lName, String email, String phone, String username, String password) {
        super(id,fName, lName, email, phone, username, password);
    }

    public Admin(String fName, String lName, String email, String phone, String username, String password) {
        super(fName, lName,  email,  phone,  username,  password);
        aux +=1;
        this.id = aux;

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

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Admin.aux = aux;
    }
}
