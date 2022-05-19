package playlist;

import album.Album;
import album.AlbumDao;
import auxAdd.AuxAdd;
import auxAdd.AuxAddDao;
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
        PlaylistDao.getInstance().insert(playlist);
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

    public void addSong(int idClient)
    {
        int i= 1;
        for (Song so: SongService.getInstance().getSongs())
        {
            System.out.println(i +". "+ so.getName());
            i +=1;
        }
        int idPlaylist = 0;
        for (Playlist elem: playlists)
        {
            if(elem.getIdClient() == idClient)
            {
                idPlaylist = elem.getId();
                break;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();

        System.out.println(SongService.getInstance().
                getSongs().get(opt-1).getName() + " added to ur plst");

        int idSong = SongService.getInstance().getSongs().get(opt-1).getId();
        AuxAdd.setAux(AuxAddDao.getInstance().getLastId());

        AuxAdd auxAdd = new AuxAdd(idSong,idPlaylist,idClient);

        AuxAddDao.getInstance().insert(auxAdd);
    }





    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        PlaylistService.playlists = playlists;
    }

}
