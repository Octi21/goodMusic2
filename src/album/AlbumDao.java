package album;

import db.Dao;
import song.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlbumDao implements Dao<Album> {
    private static ArrayList<Album> albums = new ArrayList<>();
    private static AlbumDao singelton = null;

    private AlbumDao(){
        albums = getTable();
    }

    public static AlbumDao getInstance()
    {
        if(singelton == null)
        {
            singelton = new AlbumDao();
        }
        return singelton;
    }

    @Override
    public ArrayList<Album> getTable()
    {
        ArrayList <Album> albumList  = new ArrayList<>();
        try{
            String query = "select * from album";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Album album = rowToObject(resultSet);
                albumList.add(album);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return albumList;
    }

    @Override
    public Album rowToObject(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String artistName = resultSet.getString(
                    "artistName");
            int nrSongs = resultSet.getInt("nrSongs");
            ArrayList<Song> songs = new ArrayList<>();

            int nrStreams = resultSet.getInt("nrStreams");
            int idArtist = resultSet.getInt("idArtist");

            // ce fac cu nr streams ?
            return new Album(id,name,artistName,nrSongs,songs
                    ,nrStreams,idArtist);

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Album getById(int id) {
        return new Album();
    }


    @Override
    public int insert(Album album)
    {
        if (album == null)
            return -1;
        albums.add(album);
        try {
            String query = "insert into album(id,name," +
                    "artistName,nrSongs,streamNr) values " +
                    "(?,?,?,?,?,?)";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,
                    album.getId());
            preparedStatement.setString(2,
                    album.getName());
            preparedStatement.setString(3,
                    album.getArtistName());
            preparedStatement.setInt(4,
                    album.getNumberSongs());
            preparedStatement.setInt(5,
                    album.getNrStreams());
            preparedStatement.setInt(6,album.getIdArtist());

        } catch (Exception e){
            e.printStackTrace();
        }
        return album.getId();
    }


    @Override
    public int update(Album album){
        return 0;
    }
    @Override
    public void delete(Album album){
        System.out.println("delete");
    }
}














