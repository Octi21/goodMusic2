package song;

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
                System.out.println("listed to " + elem.getName());

                elem.addStream();
                SongDao.getInstance().update(elem);

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

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
