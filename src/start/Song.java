package start;

import java.util.*;

public class Song {
    protected int id;
    protected String name;
    protected String artistName;
    protected String[] ft;
    protected float length;
    protected int streamNr;

    public Song(int id, String name, String artistName, String[] ft, float length, int streamNr) {
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
        this.ft = new String[]{};
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
                ", ft=" + Arrays.toString(ft) +
                ", length=" + length +
                ", StreamNumber" + streamNr +
                '}';
    }
}
