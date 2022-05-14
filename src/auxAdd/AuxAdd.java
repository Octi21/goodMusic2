package auxAdd;

public class AuxAdd {
    private static int aux = 0;

    private int idAdd;
    private int idSong;
    private int idPlaylist;
    private int idClient;

    public AuxAdd(int idAdd,int idSong, int idPlaylist,int idClient) {
        this.idAdd = idAdd;
        this.idSong = idSong;
        this.idPlaylist = idPlaylist;
        this.idClient = idClient;
    }

    public AuxAdd(int idSong, int idPlaylist,int idClient) {
        aux += 1;
        idAdd = aux;

        this.idSong = idSong;
        this.idPlaylist = idPlaylist;
        this.idClient = idClient;
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        AuxAdd.aux = aux;
    }
}
