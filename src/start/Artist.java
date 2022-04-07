package start;

import java.util.Arrays;
import java.util.List;

public class Artist {
    protected int id;
    protected String name;
    protected int nrSongs,nrAlbums;
    protected List<Song> songs;
    protected List<Album> albums;

    public Artist(int id, String name, int nrSongs, int nrAlbums, List<Song> songs, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.nrSongs = nrSongs;
        this.nrAlbums = nrAlbums;
        this.songs = songs;
        this.albums = albums;
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
}
