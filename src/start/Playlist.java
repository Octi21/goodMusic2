package start;

import java.util.List;

public class Playlist {
    protected int id;
    protected String name;
    protected String artistName;
    protected int numberSongs;
    protected List<Song> listSongs;

    public Playlist(int id, String name, String artistName, int numberSongs, List<Song> listSongs) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.numberSongs = numberSongs;
        this.listSongs = listSongs;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
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
}
