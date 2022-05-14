package playlist;

import album.Album;
import album.AlbumDao;
import db.Dao;
import song.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlaylistService {
    ArrayList <Playlist> playlists;

    public PlaylistService(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public PlaylistService() {
        playlists = new ArrayList<>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }
}
