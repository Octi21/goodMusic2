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

    protected int idArtist;

    public Album(int id, String name, String artistName, int numberSongs, List<Song> listSongs,int nrStreams,int idArtist) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.nrStreams = nrStreams;

        this.idArtist = idArtist;
    }
    public Album(String name, String artistName, int numberSongs, List<Song> listSongs,int nrStreams,int idArtist) {
        aux += 1;
        this.id = aux;

        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.nrStreams = nrStreams;

        this.idArtist = idArtist;

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
        this.idArtist = -1;
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
        String aux = "";
        for (Song elem: listSongs)
        {
            aux += elem.toStringghe();
        }
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", numberSongs=" + numberSongs +
                ", listSongs= " + aux +
                ", nrStreams=" + nrStreams +
                '}';
    }

    public String toStringghe(){
        return "Album{" +
                "id=" + id +
                ", name='" + name + "'}";
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

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }
}

