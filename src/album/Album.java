package album;

import song.Song;

import java.util.*;

public class Album {
    protected static int aux = 0;

    protected int id;
    protected String name;
    protected String artistName;
    protected int numberSongs;
    protected List<Song> listSongs;
    protected int nrStreams;

    public Album(int id, String name, String artistName, int numberSongs, List<Song> listSongs) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.nrStreams = 0;
        for (int i = 0; i < numberSongs; i++) {
            this.nrStreams += listSongs.get(i).getStreamNr();
        }
    }
    public Album(String name, String artistName, int numberSongs, List<Song> listSongs) {
        aux += 1;
        this.id = aux;

        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.nrStreams = 0;
        for (int i = 0; i < numberSongs; i++) {
            this.nrStreams += listSongs.get(i).getStreamNr();
        }
    }

    public Album()
    {
        aux += 1;
        this.id = aux;

        this.name = "";
        this.artistName = "";
        this.numberSongs = 0;
        this.listSongs = null;
        this.nrStreams = 0;
    }


    public void renewStreams()
    {
        int nr = 0;
        for (int i = 0; i < numberSongs; i++) {
            nr += listSongs.get(i).getStreamNr();
        }
        this.nrStreams = nr;
    }


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", numberSongs=" + numberSongs +
                ", listSongs=" + listSongs +
                ", nrStreams=" + nrStreams +
                '}';
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Album.aux = aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getNumberSongs() {
        return numberSongs;
    }

    public void setNumberSongs(int numberSongs) {
        this.numberSongs = numberSongs;
    }

    public List<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public int getNrStreams() {
        return nrStreams;
    }

    public void setNrStreams(int nrStreams) {
        this.nrStreams = nrStreams;
    }
}