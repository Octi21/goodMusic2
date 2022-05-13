package playlist;

import song.Song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    protected static int aux = 0;

    protected int id;
    protected String name;
    protected String creatorName;
    protected int numberSongs;
    protected ArrayList<Song> listSongs;

    protected int idClient;

    public Playlist(int id, String name, String creatorName, int numberSongs, ArrayList<Song> listSongs,int idClient) {
        this.id = id;
        this.name = name;
        this.creatorName = creatorName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.idClient = idClient;
    }

    public Playlist(String name, String creatorName, int numberSongs, ArrayList<Song> listSongs,int idClient) {
        aux +=1;
        id = aux;

        this.name = name;
        this.creatorName = creatorName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
        this.idClient = idClient;
    }

    public Playlist() {
        aux +=1;
        id = aux;

        this.name = "";
        this.creatorName = "";
        this.numberSongs = 0;
        this.listSongs = new ArrayList<>();
        this.idClient = -1;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + creatorName + '\'' +
                ", numberSongs=" + numberSongs +
                ", listSongs=" + listSongs +
                '}';
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getNumberSongs() {
        return numberSongs;
    }

    public void setNumberSongs(int numberSongs) {
        this.numberSongs = numberSongs;
    }

    public ArrayList<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(ArrayList<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Playlist.aux = aux;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}

