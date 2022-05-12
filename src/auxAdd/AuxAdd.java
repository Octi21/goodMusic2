package auxAdd;

public class AuxAdd {
    private int idAdd;
    private int idSong;
    private int idPlaylist;

    public AuxAdd(int idAdd,int idSong, int idPlaylist) {
        this.idAdd = idAdd;
        this.idSong = idSong;
        this.idPlaylist = idPlaylist;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public int getIdAdd() {
        return idAdd;
    }

    public void setIdAdd(int idAdd) {
        this.idAdd = idAdd;
    }
}
