package album;

import song.Song;
import song.SongDao;
import song.SongService;

import java.util.ArrayList;
import java.util.List;

public class AlbumService {
    private static ArrayList <Album> albums = new ArrayList<>();
    private static  AlbumService singelton = null;

    private AlbumService()
    {
        albums = AlbumDao.getInstance().getTable();
    }

    public static AlbumService getInstance()
    {
        if(singelton == null)
        {
            singelton = new AlbumService();
        }
        return singelton;
    }

    public int getLastId(){
        int n = albums.size();
        if (n == 0)
            return 0;
        else
            return albums.get(n-1).getId();
    }


    public void listend(int idAlbum)
    {
        for(Album elem : albums)
        {
            if(elem.getId() == idAlbum)
            {

                System.out.println("listed to Album: " + elem.getName());
                for(Song so: elem.getListSongs())
                {
                    SongService.getInstance().listened(so.getId());
                }
                break;
            }
        }
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public static void setAlbums(ArrayList<Album> albums) {
        AlbumService.albums = albums;
    }



}
