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
//        lName = lName;
//        email = email;
//        phone = phone;
//        username = username;
//        password = password;
    }


}
