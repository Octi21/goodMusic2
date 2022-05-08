package album;

import java.util.ArrayList;

public class AlbumService {
    private ArrayList <Album> albums;

    public AlbumService(ArrayList<Album> albums) {
        this.albums = albums;
    }
    public AlbumService() {
        albums = new ArrayList<>();
    }

}
