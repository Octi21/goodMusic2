package main;


import album.Album;
import album.AlbumDao;
import song.Song;
import song.SongDao;
import song.SongService;
import users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList <Song> songs = new ArrayList<>();
        songs = SongDao.getInstance().getTable();

        SongService songService = new SongService(songs);
//        System.out.println(songs);
        System.out.println("Songs:");
        for(Song elem: songs)
        {
            System.out.println(elem);
        }

        ArrayList <Album> albums = new ArrayList<>();
        albums = AlbumDao.getInstance().getTable();
        System.out.println("Albums:");
        for(Album elem: albums)
        {
            System.out.println(elem);
        }



        ArrayList <Client> clients = new ArrayList<Client>();
        clients = ClientDao.getInstance().getTable();
        ClientService clientService = new ClientService(clients);

        System.out.println("Clients:");
        for(Client elem: clients)
        {
            System.out.println(elem);
        }

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. login");
            System.out.println("2. create");
            System.out.println("3. exit");

            int opt = scanner.nextInt();

            if(opt == 1)
            {
                System.out.print("username/email: ");
                String username = scanner.next();
                System.out.print("password: ");
                String password = scanner.next();
                System.out.println(username);
                System.out.println(password);

                while(clientService.login(username,password) != 1)
                {
                    if(clientService.login(username,password) == -1)
                        System.out.println("wrong password");
                    else
                        System.out.println("try again");
                    System.out.print("username/email: ");
                    username = scanner.next();
                    System.out.print("password: ");
                    password = scanner.next();
                }



            }
            else if(opt == 2)
            {
                System.out.println("register: ");
                Client client = clientService.register();
                clients.add(client);
                System.out.println(client);
                break;
            }
            else if(opt == 3)
            {
                System.out.println("bye");
                break;
            }
            else
            {
                System.out.println("type again");
            }

        }

    }
}