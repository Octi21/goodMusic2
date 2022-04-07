package start;

import java.util.*;

public class Album {
    protected int id;
    protected String name;
    protected String artistName;
    protected int numberSongs;
    protected Song[] listSongs;
    protected int nrStreams;

    public Album(int id, String name, String artistName, int numberSongs, Song[] listSongs) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.nrStreams = 0;
        for (int i = 0; i < numberSongs; i++) {
            this.nrStreams += listSongs[i].streamNr;
        }
    }

    public void renewStreams()
    {
        for (int i = 0; i < numberSongs; i++) {
            this.nrStreams += listSongs[i].streamNr;
        }
    }


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", numberSongs=" + numberSongs +
                ", listSongs=" + Arrays.toString(listSongs) +
                ", nrStreams=" + nrStreams +
                '}';
    }
}
