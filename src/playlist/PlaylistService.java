package playlist;

import album.Album;
import album.AlbumDao;
import db.Dao;
import song.Song;
import song.SongService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaylistService {

    private static ArrayList <Playlist> playlists = new ArrayList<>();
    private static PlaylistService singelton = null;

    private PlaylistService() {
        playlists = PlaylistDao.getInstance().getTable();
    }

    public static PlaylistService getInstance() {
        if(singelton == null)
            singelton = new PlaylistService();
        return singelton;
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

    public void playPlaylist(int idClient)
    {
        for(Playlist elem: playlists)
        {
            if(elem.getIdClient() == idClient)
            {
                System.out.println("listening to Playlist: "
                        + elem.getName());
                for(Song so: elem.getListSongs())
                {
                    SongService.getInstance().listened(so.getId());
                }

                break;
            }
        }
    }




    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
