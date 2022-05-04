package start;

import java.util.*;

public class Song {
    protected int id;
    protected String name;
    protected String artistName;
    protected String[] ft;
    protected float length;
    protected int streamNr;
    protected String path;

    public Song(int id, String name, String artistName, String[] ft, float length, int streamNr,String path) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.ft = ft;
        this.length = length;
        this.streamNr = streamNr;
        this.path = path;
    }
    public Song()
    {
        this.id = 0;
        this.name = "";
        this.artistName = "";
        this.ft = new String[]{};
        this.length = 0;
        this.streamNr = 0;
        this.path = "";
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
                ", ft=" + Arrays.toString(ft) +
                ", length=" + length +
                ", StreamNumber= " + streamNr +
                ", StreamNumber= " + path +
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

    public String[] getFt() {
        return ft;
    }

    public void setFt(String[] ft) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
