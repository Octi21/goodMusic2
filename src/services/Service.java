package services;

import users.*;

public class Service {
    private static UserService us = new UserService();

    public static void creareUser()
    {
        us.CreateUser();
        System.out.println("ghe");
    }

    public static UserService getUs() {
        return us;
    }
}
