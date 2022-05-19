package song;

import java.util.*;

public class Song {
    protected static int aux = 0;

    protected int id;
    protected String name;
    protected String artistName;
    protected String ft;
    protected float length;
    protected int streamNr;

    protected int idArtist;
    protected int idAlbum;

    public Song(int id, String name, String artistName, String ft, float length, int streamNr, int idArtist, int idAlbum) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.ft = ft;
        this.length = length;
        this.streamNr = streamNr;
        this.idArtist = idArtist;
        this.idAlbum = idAlbum;
    }

    public Song(String name, String artistName, String ft, float length, int streamNr, int idArtist, int idAlbum) {
        this.name = name;
        this.artistName = artistName;
        this.ft = ft;
        this.length = length;
        this.streamNr = streamNr;
        this.idArtist = idArtist;
        this.idAlbum = idAlbum;

        aux += 1;
        this.id = aux;
    }


    public Song()
    {
        aux += 1;
        this.id = aux;
        this.name = "";
        this.artistName = "";
        this.ft = "";
        this.length = 0;
        this.streamNr = 0;
    }


    public void addStream()
    {
        streamNr ++;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistName='" + artistName + '\'' +
                ", ft='" + ft + '\'' +
                ", length=" + length +
                ", streamNr=" + streamNr +
                ", idArtist=" + idArtist +
                ", idAlbum=" + idAlbum +
                '}';
    }

    public String toStringghe() {
        return " (" +
                "id=" + id +
                ", name='" + name + "' " +
                ", nrStr=" +  streamNr  +") ";

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

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getStreamNr() {
        return streamNr;
    }

    public void setStreamNr(int streamNr) {
        this.streamNr = streamNr;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Song.aux = aux;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }
}
