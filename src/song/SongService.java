package song;

import java.util.ArrayList;
import java.util.Scanner;

public class SongService {
    ArrayList <Song> songs;

    public SongService()
    {
        songs = new ArrayList<>();
    }

    public SongService(ArrayList<Song> songs)
    {
        this.songs =  songs;
    }

    public int lastId()
    {
        int a = songs.size();
        if (a == 0)
            return 0;
        return songs.get(a-1).getId();
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

}
