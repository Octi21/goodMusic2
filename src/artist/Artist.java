package artist;



import album.Album;
import song.Song;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    protected static int aux = 0;
    protected int id;
    protected String name;
    protected int nrSongs,nrAlbums;
    protected ArrayList<Song> songs;
    protected ArrayList<Album> albums;

    public Artist(int id, String name, int nrSongs, int nrAlbums, ArrayList<Song> songs, ArrayList<Album> albums) {
        this.id = id;
        this.name = name;
        this.nrSongs = nrSongs;
        this.nrAlbums = nrAlbums;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist(String name, int nrSongs, int nrAlbums, ArrayList<Song> songs, ArrayList<Album> albums) {
        aux += 1;
        id = aux;

        this.name = name;
        this.nrSongs = nrSongs;
        this.nrAlbums = nrAlbums;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist() {
        aux += 1;
        id = aux;
        this.name = "";
        this.nrSongs = 0;
        this.nrAlbums = 0;
        this.songs = null;
        this.albums = null;
    }

    public void addSong(Song song)
    {
        nrSongs ++;
        songs.add(song);
    }
    public void addAlbum(Album   album)
    {
        nrAlbums ++;
        albums.add(album);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nrSongs=" + nrSongs +
                ", nrAlbums=" + nrAlbums +
                ", songs=" + songs +
                ", albums=" + albums +
                '}';
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Artist.aux = aux;
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

    public int getNrSongs() {
        return nrSongs;
    }

    public void setNrSongs(int nrSongs) {
        this.nrSongs = nrSongs;
    }

    public int getNrAlbums() {
        return nrAlbums;
    }

    public void setNrAlbums(int nrAlbums) {
        this.nrAlbums = nrAlbums;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}
