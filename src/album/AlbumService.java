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


    public void listened(int idAlbum)
    {
        for(Album elem : albums)
        {
            if(elem.getId() == idAlbum)
            {
                int streams = 0;

                System.out.println("listening to Album: " + elem.getName());
                for(Song so: elem.getListSongs())
                {
                    SongService.getInstance().listened(so.getId());
                    streams += so.getStreamNr();
                }
                elem.setNrStreams(streams);
                AlbumDao.getInstance().update(elem);
                break;
            }
            // !!!!!!!!!!! aici numara cate streamuri are albumul si
            // verifica daca are streamuri bune pe melodii
        }
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        AlbumService.albums = albums;
    }



}
