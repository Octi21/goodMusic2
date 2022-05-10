package services;

import users.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    ArrayList<User> users;

    public UserService()
    {
        users = new ArrayList<>();
    }

    public void CreateUser()
    {
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        String lName = scanner.nextLine();
        String email = scanner.nextLine();
        String phone = scanner.nextLine();
        String username = scanner.nextLine();
        String password = scanner.nextLine();

//        User ob1 = new User(fName,lName,email,phone,username,password);
//        this.users.add(ob1);
        System.out.println("User adaugat");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "users=" + users +
                '}';
    }
}
