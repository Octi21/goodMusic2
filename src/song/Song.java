package song;

import java.util.*;

public class Song {
    protected int id;
    protected String name;
    protected String artistName;
    protected String ft;
    protected float length;
    protected int streamNr;

    public Song(int id, String name, String artistName, String ft, float length, int streamNr) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.ft = ft;
        this.length = length;
        this.streamNr = streamNr;
    }
    public Song()
    {
        this.id = 0;
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
                ", ft=" + ft +
                ", length=" + length +
                ", StreamNumber= " + streamNr +
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

}
