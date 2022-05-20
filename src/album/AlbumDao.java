package album;

import db.Dao;
import song.Song;
import song.SongDao;

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
            String query = "select * from album;";
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

    public ArrayList<Album> albumByIdArtist(int idArtist)
    {
        ArrayList <Album> albumList  = new ArrayList<>();
        try{
            String query = "select al.* from album al , artist ar" +
                    " where al.idArtist = ? and al.idArtist = ar.id;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1, idArtist);
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
            songs = SongDao.getInstance().songIdAlbum(id);

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
                    "artistName,nrSongs,nrStreams,idArtist) values " +
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

            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
        return album.getId();
    }


    @Override
    public int update(Album album){
        if (album == null)
            return -1;
        try{
            String query = "update album set nrStreams = ? where id = ?";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,album.getNrStreams());
            preparedStatement.setInt(2,album.getId());
            preparedStatement.executeUpdate();
            for(Album elem: albums)
            {
                if (elem.getId() == album.getId())
                {
                    elem.setNrStreams(album.getNrStreams());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return album.getId();
    }
    @Override
    public void delete(Album album){
        System.out.println("delete");
    }

    public void setAlbums(ArrayList<Album> albums) {
        AlbumDao.albums = albums;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
}














