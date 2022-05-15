package main;


import album.Album;
import album.AlbumDao;
import album.AlbumService;
import artist.Artist;
import artist.ArtistDao;
import artist.ArtistService;
import auxAdd.AuxAdd;
import auxAdd.AuxAddDao;
import card.Card;
import card.CardDao;
import card.CardService;
import playlist.Playlist;
import playlist.PlaylistDao;
import playlist.PlaylistService;
import song.Song;
import song.SongDao;
import song.SongService;
import users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            //   songs
        ArrayList <Song> songs = new ArrayList<>();
        songs = SongDao.getInstance().getTable();
        SongService songService = new SongService(songs);
        System.out.println("Songs:");
        for(Song elem: songs)
        {
            System.out.println(elem);
        }


            //   albums
        ArrayList <Album> albums = new ArrayList<>();
        albums = AlbumDao.getInstance().getTable();
        AlbumService albumService = new AlbumService(albums);
        System.out.println("Albums:");
        for(Album elem: albums)
        {
//            ArrayList <Song> songs1 = SongDao.getInstance().songIdAlbum(elem.getId());
//            elem.setListSongs(songs1);

            System.out.println(elem);
        }

            //  artist
        ArrayList <Artist> artists = ArtistDao.getInstance().getTable();
        ArtistService artistService = new ArtistService(artists);
        System.out.println("Artists:");
        for(Artist elem: artists)
        {
            System.out.println(elem);
        }




            //   playlist
        ArrayList <Playlist> playlists =
                PlaylistDao.getInstance().getTable();
        PlaylistService playlistService = new PlaylistService(playlists);

            //   adds
        ArrayList <AuxAdd> adds =
                AuxAddDao.getInstance().getTable();


        ArrayList <Admin> admins = AdminDao.getInstance().getTable();
        AdminService adminService = new AdminService(admins);

        ArrayList <Client> clients = new ArrayList<Client>();
        clients = ClientDao.getInstance().getTable();
        ClientService clientService = new ClientService(clients);
        System.out.println("Clients:");
        for(Client elem: clients)
        {
            System.out.println(elem);
        }

        ArrayList <Card> cards = CardDao.getInstance().getTable();
        CardService cardService = new CardService(cards);


        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. login");
            System.out.println("2. create");
            System.out.println("3. exit");
            System.out.println("4. admin");

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
            else if( opt == 4)
            {
                break;
            }
            else
            {
                System.out.println("type again");
            }

        }

    }
}