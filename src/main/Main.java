package main;

//import  start.*;

import start.Card;
//import start.Client;
import users.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("ghe");
        String number = "1234 2345 1234 2345",holderName = "Andrei Ghe";
        int cvv = 123;
        Date expDate = new Date(2022, Calendar.DECEMBER,3);
        String iBan = "RO12300000GHE123";
        Card card = new Card(number,holderName,cvv,expDate,iBan);
        int id = 1;
        String fName = "Andrei", lName = "Ghe";
        String email= "andreighe123@gmail.com", phone="0766602121";

        Client client = new Client(id,fName,lName,email,phone,"Andrei",
                "123",card);

        System.out.println(client);


        String nume = new String("andrei");
        if(nume.equals("andrei"))
            System.out.println(true);


    }
}