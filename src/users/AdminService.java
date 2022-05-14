package users;

import java.util.ArrayList;

public class AdminService {
    ArrayList <Admin> admins;

    public AdminService() {
        admins = new ArrayList<>();
    }

    public AdminService(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }
}
