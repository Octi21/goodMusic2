package artist;

import album.Album;
import song.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtistService {
    private static ArrayList<Artist> artists = new ArrayList<>();
    private static ArtistService singelton = null;

    private ArtistService()
    {
        artists = ArtistDao.getInstance().getTable();
    }

    public static ArtistService getInstance()
    {
        if(singelton == null)
            singelton = new ArtistService();
        return singelton;
    }


    public int getLastId()
    {
        return artists.get(artists.size() - 1).getId();
    }


    public void add()
    {
        Artist.setAux(getLastId());

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Artist Info");
//        rotected int id;
//        protected String name;
//        protected int nrSongs,nrAlbums;
//        protected ArrayList<Song> songs;
//        protected ArrayList<Album> albums;

        System.out.print("name: ");
        String name = scanner.next();

        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Album> albums = new ArrayList<>();


        Artist artist = new Artist(name,0,0,
                songs,albums);
        ArtistDao.getInstance().insert(artist);
        artists.add(artist);

    }


    public  ArrayList<Artist> getArtists() {
        return artists;
    }

    public  void setArtists(ArrayList<Artist> artists) {
        ArtistService.artists = artists;
    }
}
