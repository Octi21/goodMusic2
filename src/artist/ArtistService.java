package artist;

import java.util.ArrayList;

public class ArtistService {
    private ArrayList<Artist> artists;

    public ArtistService()
    {
        artists = new ArrayList<>();
    }

    public ArtistService(ArrayList<Artist> artists) {
        this.artists = artists;
    }
}
