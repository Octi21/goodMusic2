package main;

import song.Song;
import song.SongDao;
import song.SongService;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBtest {

    public static void main(String[] args) {

//        try {
//
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3307/javadb",
//                    "root", "root123");
//
//            Statement statement = conn.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(
//                    "select * from users");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(
//                        "lname"));
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }

//        Song song;
//        ArrayList <Song> songs = new ArrayList<>();
//        songs = SongDao.getInstance().getTable();
//        System.out.println(songs);
//
//
//        SongService songService= new SongService(songs);
//        Song.setAux(songService.lastId());
//        Song ob = songService.CreateSong();
//        System.out.println(ob);


        LocalDate myObj = LocalDate.now(); // Create a date object
        System.out.println(myObj); // Display the current date

//        Date date = Date.valueOf("2000-11-24");

            LocalDate date = LocalDate.parse("2000-11-24");

//        if (date.isEqual("2000-11-24"))
//            System.out.println(1);

        System.out.println(date.isEqual(LocalDate.parse("2000-11-24")));
        System.out.println(date.plusMonths(1));
        System.out.println(date.plusMonths(1));



        System.out.println(date );
        System.out.println(Date.valueOf("2000-11-24"));
        if (myObj.equals(Date.valueOf("2022-05-15")))
            System.out.println(1);

        Date date2 = Date.valueOf("2000-12-29");

//
//        System.out.println(date2.before(date));
//        System.out.println((date2.getTime() - date.getTime()));

    }
}
