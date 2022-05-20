package album;

import artist.Artist;
import artist.ArtistDao;
import artist.ArtistService;
import song.Song;
import song.SongDao;
import song.SongService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
//                    System.out.println(so.getStreamNr());
                    streams += so.getStreamNr() + 1;
                }
                elem.setNrStreams(streams);
                AlbumDao.getInstance().update(elem);
                break;
            }
            // !!!!!!!!!!! aici numara cate streamuri are albumul si
            // verifica daca are streamuri bune pe melodii
        }
    }

    public void add()
    {
        Album.setAux(getLastId());

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        protected int id;
//        protected String name;
//        protected String artistName;
//        protected int numberSongs;
//        protected List<Song> listSongs;
//        protected int nrStreams;
//
//        protected int idArtist;
        System.out.println("Album info: ");

        System.out.print("name: ");
        String name = scanner.next();
        System.out.print("artist name: ");
        String artistName = scanner.next();
        System.out.print("number of songs: ");
        int number = scanner.nextInt();
        System.out.println("Avalable artists:");
        for (Artist elem: ArtistService.getInstance().getArtists())
        {
            System.out.println("id= " +elem.getId() +" name= "+elem.getName());
        }
        System.out.print("id Artist: ");
        int idArtist = scanner.nextInt();


        ArrayList<Song> songs = new ArrayList<>();

        Album album = new Album(name,artistName,number,songs,
                0,idArtist);
        AlbumDao.getInstance().insert(album);
        albums.add(album);


    }


    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        AlbumService.albums = albums;
    }



}
