package users;

import album.AlbumDao;
import album.AlbumService;
import artist.Artist;
import artist.ArtistDao;
import artist.ArtistService;
import services.Service;
import song.Song;
import song.SongService;
import start.Audit;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AdminService {
    private static ArrayList <Admin> admins = new ArrayList<>();
    private static AdminService singelton = null;
    private static Audit audit = new Audit();

    private AdminService() {
        admins = AdminDao.getInstance().getTable();
    }

    public static AdminService getInstance() {
        if(singelton == null)
        {
            singelton = new AdminService();
        }
        return singelton;
    }

    public int login(String username, String password)
    {
        int ok = 0, ok2 = 0;
        for (Admin elem: admins)
        {
            if (elem.getUsername().equals(username)  ||
                    elem.getEmail().equals(username))
            {
                ok +=1;
                if(elem.getPassword().equals(password))
                {
                    ok2 = 1;
//                    System.out.println("logged");
                    return elem.getId();
                }
            }
        }
        if(ok != 0)
            return -1;
        return 0;
    }

    public Admin log()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("username/email: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();

        while(login(username,password) <= 0)
        {
            if(login(username,password) == -1)
                System.out.println("wrong password");
            else
                System.out.println("try again");
            System.out.print("username/email: ");
            username = scanner.next();
            System.out.print("password: ");
            password = scanner.next();
        }
        Admin admin = AdminDao.getInstance().
                getById(login(username,password));
        return admin;
    }

    public void addArtist()
    {
        ArtistService.getInstance().add();
        audit.write("Artist added");
    }

    public void addAlbum()
    {
        AlbumService.getInstance().add();

        ArtistDao.getInstance().setArtists(
                ArtistDao.getInstance().getTable());


        for(Artist elem : ArtistDao.getInstance().getTable())
        {
            elem.setNrAlbums(elem.getAlbums().size());
            ArtistDao.getInstance().update(elem);
        }

        ArtistService.getInstance().setArtists(
                ArtistDao.getInstance().getTable());


        audit.write("Album added");
    }

    public void addSong()
    {
        SongService.getInstance().add();

        ArtistDao.getInstance().setArtists(
                ArtistDao.getInstance().getTable());
        AlbumDao.getInstance().setAlbums(
                AlbumDao.getInstance().getTable());

        for(Artist elem : ArtistDao.getInstance().getTable())
        {
            elem.setNrSongs(elem.getSongs().size());
            ArtistDao.getInstance().update(elem);
        }

        ArtistService.getInstance().setArtists(
                ArtistDao.getInstance().getTable());
        AlbumService.getInstance().setAlbums(
                AlbumDao.getInstance().getTable());

        audit.write("Song added");
    }

    public void showSongs()
    {
        PriorityQueue <Song> songs = new PriorityQueue<>();

        songs.addAll(SongService.getInstance().getSongs());

        while (! songs.isEmpty())
        {
            Song s = songs.poll();
            System.out.println(s.toStringghe());
        }
    }



    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        AdminService.admins = admins;
    }
}
