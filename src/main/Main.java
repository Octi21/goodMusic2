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
        SongService songService = SongService.getInstance();
        System.out.println("Songs:");
        for(Song elem: songs)
        {
            System.out.println(elem);
        }
//        for(Song elem: songService.getSongs())
//        {
//            System.out.println(elem);
//        }


            //   albums
        ArrayList <Album> albums = new ArrayList<>();
        albums = AlbumDao.getInstance().getTable();
        AlbumService albumService =  AlbumService.getInstance();
        System.out.println("Albums:");
        for(Album elem: albums)
        {
            System.out.println(elem);
        }

            //  artist
        ArrayList <Artist> artists = ArtistDao.getInstance().getTable();
        ArtistService artistService = ArtistService.getInstance();
        System.out.println("Artists:");
        for(Artist elem: artists)
        {
            System.out.println(elem);
        }




            //   playlist
        ArrayList <Playlist> playlists =
                PlaylistDao.getInstance().getTable();
        PlaylistService playlistService =PlaylistService.getInstance();
        System.out.println("Playlists:");
        for(Playlist elem: playlists)
        {
            System.out.println(elem);
        }

            //   adds
        ArrayList <AuxAdd> adds =
                AuxAddDao.getInstance().getTable();

            //  admin
        ArrayList <Admin> admins = AdminDao.getInstance().getTable();
        AdminService adminService = AdminService.getInstance();

            // clients
        ArrayList <Client> clients = new ArrayList<Client>();
        clients = ClientDao.getInstance().getTable();
        ClientService clientService = ClientService.getInstance();
        System.out.println("Clients:");
        for(Client elem: clients)
        {
            System.out.println(elem);
        }

            // cards
        ArrayList <Card> cards = CardDao.getInstance().getTable();
        CardService cardService =  CardService.getInstance();
        System.out.println("Cards:");
        for(Card elem: cards)
        {
            System.out.println(elem);
        }



        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. login");
            System.out.println("2. create account");
            System.out.println("3. exit");
            System.out.println("4. admin");

            int opt = scanner.nextInt();

            if(opt == 1)
            {
                Client client = clientService.log(); // !!clientul logat
                System.out.println(client);

                while(true)
                {
                    if (client.getPlaylist().getName().length() != 0) {
                        System.out.println("1. Add song to playlist");
                        System.out.println("2. play playlist");
                        System.out.println("3. play song");
                        System.out.println("4. play album");
                        System.out.println("5. exit");

                        opt = scanner.nextInt();
                        if (opt == 1)
                        {
                            System.out.println(PlaylistService.getInstance().getPlaylists());
                            clientService.addSongPlaylist(client.getId());
                            System.out.println(PlaylistService.getInstance().getPlaylists());

                        }

                        else if(opt == 2) {
                            System.out.println(PlaylistService.getInstance().getPlaylists());
                            clientService.playPlaylist(client.getId());
                            System.out.println(PlaylistService.getInstance().getPlaylists());
                            System.out.println(SongService.getInstance().getSongs());
                        }
                        else if (opt == 3) {
                            System.out.println(AlbumService.getInstance().getAlbums());
                            System.out.println(AlbumDao.getInstance().getAlbums());
                            clientService.playSong();

                            for(Song elem: songs)
                            {
                                System.out.println(elem);
                            }
                            for(Song elem: songService.getSongs())
                            {
                                System.out.println(elem);
                            }
                            System.out.println(AlbumService.getInstance().getAlbums());
                            System.out.println(AlbumDao.getInstance().getAlbums());

                        }
                        else if (opt == 4) {
                            System.out.println(AlbumService.getInstance().getAlbums());
                            clientService.playAlbum();
                            for(Album elem: albumService.getAlbums())
                            {
                                System.out.println(elem);
                            }
                        }
                        else if (opt == 5) {
                            System.out.println("bye");
                            break;
                        }
                        else{
                            System.out.println("try again");
                        }



                    } else {
                        System.out.println("1. Create playlist");
                        System.out.println("2. play song");
                        System.out.println("3. play album");
                        System.out.println("4. exit");

                        opt = scanner.nextInt();

                        if(opt == 1) {
                            clientService.createPlaylist(
                                    playlistService,client);
                        }
                        else if (opt == 2) {
                            clientService.playSong();

                        }
                        else if (opt == 3) {
                            clientService.playAlbum();
                        }
                        else if (opt == 4) {
                            System.out.println("bye");
                            break;
                        }
                        else{
                            System.out.println("try again");
                        }
                    }
                }




            }
            else if(opt == 2)
            {
                System.out.println("register: ");
                Client client = clientService.register();


                System.out.println(ClientService.getInstance().getClients());
//                clients.add(client);
//                System.out.println(client);
                System.out.println("Account created go and loggin");
            }
            else if(opt == 3)
            {
                System.out.println("bye");
                break;
            }
            else if( opt == 4)
            {
                Admin admin = adminService.log(); // admin logat
                System.out.println(admin);

                while (true)
                {
                    System.out.println("1. add artist");
                    System.out.println("2. add album");
                    System.out.println("3. add song");
                    System.out.println("4. most listened?");
                    System.out.println("5. exit");

                    Scanner scanner1 = new Scanner(System.in);
                    int opt1 = scanner1.nextInt();

                    if(opt1 == 1)
                    {
                        System.out.println(ArtistService.getInstance().getArtists());
                        AdminService.getInstance().addArtist();
                        System.out.println(ArtistService.getInstance().getArtists());

                    }
                    else if(opt1 == 2)
                    {
                        AdminService.getInstance().addAlbum();
                        System.out.println(AlbumService.getInstance().getAlbums());
                        System.out.println(ArtistService.getInstance().getArtists());
                        for (Artist elem: ArtistService.getInstance().getArtists())
                        {
                            System.out.println(elem);
                        }
                    }
                    else if(opt1 == 3)
                    {
                        AdminService.getInstance().addSong();
                        System.out.println(SongService.getInstance().getSongs());
                        System.out.println(AlbumService.getInstance().getAlbums());

                        for (Artist elem: ArtistService.getInstance().getArtists())
                        {
                            System.out.println(elem);
                        }
                    }
                    else if(opt1 == 4)
                    {
                        AdminService.getInstance().showSongs();

                    }
                    else if(opt1 == 5)
                    {
                        System.out.println("bye");
                        break;
                    }
                    else
                    {
                        System.out.println("wrong command");
                    }

                }


            }
            else
            {
                System.out.println("type again");
            }

        }

    }
}