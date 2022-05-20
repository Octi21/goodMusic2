package song;

import album.Album;
import album.AlbumDao;
import album.AlbumService;
import artist.Artist;
import artist.ArtistService;
import playlist.Playlist;
import playlist.PlaylistDao;
import playlist.PlaylistService;

import java.util.ArrayList;
import java.util.Scanner;

public class SongService {
    private static ArrayList <Song> songs = new ArrayList<>();
    private static SongService singelton = null;

    private SongService()
    {
        songs = SongDao.getInstance().getTable();
    }

    public static SongService getInstance() {
        if(singelton == null)
            singelton = new SongService();
        return singelton;
    }

    public int lastId()
    {
        int a = songs.size();
        if (a == 0)
            return 0;
        return songs.get(a-1).getId();
    }

    public void listened(int idSong){
        for(Song elem: songs )
        {
            if (elem.getId() == idSong)
            {
                System.out.println("listening to " + elem.getName());

                elem.addStream();
                SongDao.getInstance().update(elem);

                AlbumService.getInstance().setAlbums(AlbumDao.getInstance().getTable());
                AlbumDao.getInstance().setAlbums(AlbumDao.getInstance().getTable());

                PlaylistService.getInstance().setPlaylists(
                        PlaylistDao.getInstance().getTable());
                PlaylistDao.getInstance().setPlaylists(
                        PlaylistDao.getInstance().getTable());
                // resinstantiem playlisturile si albumele pt a vedea
                //nr de streamuri
                break;
            }
        }
    }

    public Song CreateSong()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String artistName = scanner.nextLine();
        String ft = scanner.nextLine();
        float length = scanner.nextFloat();
        int streamNr = scanner.nextInt();

        int idArtist = scanner.nextInt();
        int idAlbum = scanner.nextInt();

        Song ob1 = new Song(name,artistName,ft,length,streamNr,
                idArtist,idAlbum);
        System.out.println("Song added");
        return ob1;
    }

    public void add()
    {
        Song.setAux(lastId());

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        protected int id;
//        protected String name;
//        protected String artistName;
//        protected String ft;
//        protected float length;
//        protected int streamNr;
//
//        protected int idArtist;
//        protected int idAlbum;

        System.out.println("Song info: ");

        System.out.print("name: ");
        String name = scanner.next();
        System.out.print("artist name: ");
        String artistName = scanner.next();
        System.out.print("ft: ");
        String ft = scanner.next();
        System.out.print("length: ");
        Float length = scanner.nextFloat();

        System.out.println("Avalable artists:");
        for (Artist elem: ArtistService.getInstance().getArtists())
        {
            System.out.println("id= " +elem.getId() +" name= "+elem.getName());
        }
        System.out.print("id Artist: ");
        int idArtist = scanner.nextInt();

        System.out.println("Avalable albums:");
        for (Album elem: AlbumService.getInstance().getAlbums())
        {
            System.out.println("id= " +elem.getId() +" name= "+elem.getName());
        }
        System.out.print("id album: ");
        int idAlbum = scanner.nextInt();


        Song song = new Song(name,artistName,ft,length,0,
                idArtist,idAlbum);
        SongDao.getInstance().insert(song);
        songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public static void setSongs(ArrayList<Song> songs) {
        SongService.songs = songs;
    }
}
