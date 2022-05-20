package song;

import db.Dao;
import db.DatabaseConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SongDao implements Dao<Song> {
    private static ArrayList<Song> songs = new ArrayList<>();
    private static SongDao singelton = null;


    private SongDao()
    {
        songs = getTable();
    }

    public static SongDao getInstance()
    {
        if(singelton == null)
            singelton = new SongDao();
        return singelton;
    }


    @Override
    public ArrayList<Song> getTable()
    {
        ArrayList <Song>  songList =new ArrayList<>();
        try{
            String query = "select * from song;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Song song = rowToObject(resultSet);
                songList.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return songList;

    }

    public ArrayList<Song> songIdAlbum(int idAlbum) {
        ArrayList<Song> songList = new ArrayList<>();

        try {
            String query = "select s.*  from song s, album a " +
                    "where s.idAlbum = ? and s.idAlbum = a.id;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1, idAlbum);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Song song= rowToObject(resultSet);
                songList.add(song);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return songList;
    }

    public ArrayList<Song> songIdArtist(int idArtist) {
        ArrayList<Song> songList = new ArrayList<>();

        try {
            String query = "select s.*  from song s, artist a " +
                    "where s.idArtist = ? and s.idArtist = a.id;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1, idArtist);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Song song= rowToObject(resultSet);
                songList.add(song);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return songList;
    }

    public ArrayList<Song> songIdPlaylist(int idClient) {
        ArrayList<Song> songList = new ArrayList<>();

        try {
            String query = "select s.* from client c, playlist p, " +
                    "auxAdd a, song s where p.idClient = ? and p.id " +
                    "= a.idPlaylist and a.idSong = s.id and c.id = p.idClient;";

            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Song song= rowToObject(resultSet);
                songList.add(song);
            }

        } catch (Exception e){
            System.out.println("error song in playlist");
            e.printStackTrace();
        }
        return songList;
    }


    @Override
    public Song rowToObject(ResultSet resultSet)
    {
        try{
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String artistName = resultSet.getString("artistName");
            String ft = resultSet.getString("ft");
            float length = resultSet.getFloat("length");
            int streamNr = resultSet.getInt("streamNr");

            int idArtist = resultSet.getInt("idArtist");
            int idAlbum = resultSet.getInt("idAlbum");

            return new Song(id,name,artistName,ft,length,streamNr,idArtist,idAlbum);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Song getById(int id) {
        return new Song();
    }


    @Override
    public int insert(Song song)
    {
        if (song == null)
            return -1;
        songs.add(song);
        try {
            String query = "insert into song(id,name," +
                    "artistName,ft,length,streamNr,idArtist,idAlbum) values " +
                    "(?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,song.getId());
            preparedStatement.setString(2,song.getName());
            preparedStatement.setString(3,song.getArtistName());
            preparedStatement.setString(4,song.getFt());
            preparedStatement.setFloat(5,song.getLength());
            preparedStatement.setInt(6,song.getStreamNr());

            preparedStatement.setInt(7,song.getIdArtist());
            preparedStatement.setInt(8,song.getIdAlbum());

            preparedStatement.executeUpdate();


        } catch (Exception e){
            e.printStackTrace();
        }
        return song.getId();
    }


    @Override
    public int update(Song song){
        if (song == null)
            return -1;
        try{
            String query = "update song set streamNr = ? where id = ?";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,song.getStreamNr());
            preparedStatement.setInt(2,song.getId());
            preparedStatement.executeUpdate();
            for(Song elem: songs)
            {
                if (elem.getId() == song.getId())
                {
                    elem.setStreamNr(song.getStreamNr());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return song.getId();
    }
    @Override
    public void delete(Song song){
        System.out.println("delete");
    }
}
