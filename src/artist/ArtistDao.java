package artist;

import album.AlbumDao;
import db.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArtistDao implements Dao<Artist> {
    private static ArrayList<Artist> artists = new ArrayList<>();
    private static ArtistDao singelton = null;

    private ArtistDao()
    {
        artists = getTable();
    }

    public static ArtistDao getInstance()
    {
        if(singelton == null)
            singelton = new ArtistDao();
        return singelton;
    }

    @Override
    public ArrayList<Artist> getTable()
    {
        ArrayList<Artist> artistList = new ArrayList<>();
        try{
            String query = "select * from artist;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Artist artist = rowToObject(resultSet);
                artistList.add(artist);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return artistList;
    }

    @Override
    public Artist rowToObject(ResultSet res) {
        try {
            int id = res.getInt("id");
            String name = res.getString("name");
            int nrSongs = res.getInt("nrSongs");
            int nrAlbums = res.getInt("nrAlbums");

            // cum la liste ?
            return new Artist(id,name,nrSongs,nrAlbums,null,null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Artist getById(int id) {
        return null;
    }

    @Override
    public int insert(Artist artist) {
        if (artist == null)
        {
            return -1;
        }
        artists.add(artist);
        try{
            String query = "insert into artist(id,name,nrSongs," +
                    "nrAlbums) values (?,?,?,?);";
            PreparedStatement preparedStatement = Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,artist.getId());
            preparedStatement.setString(2,artist.getName());
            preparedStatement.setInt(3,artist.getNrSongs());
            preparedStatement.setInt(4,artist.getNrAlbums());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return artist.getId();
    }

    @Override
    public int update(Artist artist) {
        return 0;
    }

    @Override
    public void delete(Artist artist) {

    }
}
