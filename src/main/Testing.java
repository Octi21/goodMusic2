package main;

import javazoom.jl.player.Player;
import start.Song;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
//        System.out.println("ghe");
//        List<Song> lista= new ArrayList<>();
//        Song s1 = new Song();
//        lista.add(s1);
//        System.out.println(lista);

//        try {
////            FileInputStream file = new FileInputStream("C:\\other\\An2Sem2\\jaba\\goodMusic2\\src\\music\\Alien.mp3");
//            FileInputStream file = new FileInputStream("src\\music\\Alien.mp3");
//            Player playMP3 = new Player(file);
//            playMP3.play();
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println("ghe");
//        }
        Scanner scanner = new Scanner(System.in);

        Song s1 = new Song();
        s1.setPath("src\\music\\Alien.mp3");
        s1.setName("Alien");
        System.out.println(s1);


        List<Song> lista = new ArrayList<>();
        lista.add(s1);

        int optiune = 10;
        int opt;
        while(true)
        {
            System.out.println("1: play song || 2: exit");

            optiune = scanner.nextInt();
            System.out.println(optiune);
            if(optiune == 1)
            {
                System.out.println("Alege melodie\n");
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(i +": " + lista.get(i).getName());
                }
                opt = scanner.nextInt();
                String loc = lista.get(opt).getPath();
                try {
                    FileInputStream file = new FileInputStream(loc);
                    Player playMP3 = new Player(file);
                    playMP3.play();
                    System.out.println("Am ajuns aici");
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("ghe");
                }
                System.out.println("Am ajuns aici");

            }
            else if (optiune == 2)
            {
                break;
            }



        }


    }
}