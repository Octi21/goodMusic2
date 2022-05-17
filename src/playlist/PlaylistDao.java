package playlist;

import album.Album;
import album.AlbumDao;
import db.Dao;
import song.Song;
import song.SongDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlaylistDao implements Dao<Playlist> {
    private static ArrayList<Playlist> playlists = new ArrayList<>();
    private static PlaylistDao singelton = null;

    private PlaylistDao(){
        playlists = getTable();
    }

    public static PlaylistDao getInstance()
    {
        if(singelton == null)
        {
            singelton = new PlaylistDao();
        }
        return singelton;
    }

    @Override
    public ArrayList<Playlist> getTable()
    {
        ArrayList <Playlist> playlistList  = new ArrayList<>();
        try{
            String query = "select * from playlist;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Playlist playlist = rowToObject(resultSet);
                playlistList.add(playlist);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return playlistList;
    }

    public Playlist getPlaylistByClient(int idClient)
    {
        Playlist playlist = new Playlist();
        try{
            String query = "select p.* from client c , playlist p " +
                    "where p.idClient = ?;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                playlist = rowToObject(resultSet);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ghe");
        }
        return playlist;
    }


    @Override
    public Playlist rowToObject(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String creatorName = resultSet.getString(
                    "creatorName");
            int nrSongs = resultSet.getInt("nrSongs");


            int idClient = resultSet.getInt("idClient");

            ArrayList<Song> songs = SongDao.getInstance().songIdPlaylist(idClient);
//            ArrayList<Song> songs = new ArrayList<>();

            // ce fac cu nr streams ?
            return new Playlist(id,name,creatorName,nrSongs,songs
                    ,idClient);

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Playlist getById(int id) {
        return new Playlist();
    }


    @Override
    public int insert(Playlist playlist)
    {
        if (playlist == null)
            return -1;
        playlists.add(playlist);
        try {
            String query = "insert into playlist(id,name," +
                    "creatorName,nrSongs,idClient) values " +
                    "(?,?,?,?,?)";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,
                    playlist.getId());
            preparedStatement.setString(2,
                    playlist.getName());
            preparedStatement.setString(3,
                    playlist.getCreatorName());
            preparedStatement.setInt(4,
                    playlist.getNumberSongs());
            preparedStatement.setInt(5,
                    playlist.getIdClient());

            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
        return playlist.getId();
    }


    @Override
    public int update(Playlist playlist){
        return 0;
    }
    @Override
    public void delete(Playlist playlist){
        System.out.println("delete");
    }

}
