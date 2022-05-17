package playlist;

import album.Album;
import album.AlbumDao;
import db.Dao;
import song.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaylistService {
    ArrayList <Playlist> playlists;

    public PlaylistService(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public PlaylistService() {
        playlists = new ArrayList<>();
    }


    public int getLastId(){
        int n = playlists.size();
        if (n == 0)
            return 0;
        else
            return playlists.get(n-1).getId();

    }

    public Playlist create(int idClient)
    {
        Playlist.setAux(getLastId());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Playlist name: ");
        String name = scanner.next();
        System.out.println("creator name: ");
        String creatorName = scanner.next();

        Playlist playlist = new Playlist(name,creatorName,
                0,new ArrayList<Song>(),idClient);

        playlists.add(playlist);
        return playlist;


    }



    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
