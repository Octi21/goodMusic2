package main;

import song.Song;
import song.SongDao;
import song.SongService;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

        Song song;
        ArrayList <Song> songs = new ArrayList<>();
        songs = SongDao.getObject().getTable();
        System.out.println(songs);


        SongService songService= new SongService(songs);
        Song.setAux(songService.lastId());
        Song ob = songService.CreateSong();
        System.out.println(ob);



    }
}
