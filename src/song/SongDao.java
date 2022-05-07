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

    public static SongDao getObject()
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
            String query = "select * from song";
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

            return new Song(id,name,artistName,ft,length,streamNr);

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
                    "artistName,ft,length,streamNr) values " +
                    "(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,song.getId());
            preparedStatement.setString(2,song.getName());
            preparedStatement.setString(3,song.getArtistName());
            preparedStatement.setString(4,song.getFt());
            preparedStatement.setFloat(5,song.getLength());
            preparedStatement.setInt(6,song.getStreamNr());

        } catch (Exception e){
            e.printStackTrace();
        }
        return song.getId();
    }


    @Override
    public int update(Song song){
        return 0;
    }
    @Override
    public void delete(Song song){
        System.out.println("delete");
    }
}
