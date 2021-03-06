package users;

import card.Card;
import card.CardDao;
import db.Dao;
import playlist.Playlist;
import playlist.PlaylistDao;
import song.SongDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientDao implements Dao<Client> {
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ClientDao singelton = null;

    private ClientDao() {
        clients = getTable();
    }

    public static ClientDao getInstance()
    {
        if(singelton == null)
            singelton = new ClientDao();
        return singelton;
    }




    @Override
    public Client rowToObject(ResultSet res) {
        try{
            int id = res.getInt("id");
            String fName = res.getString("fName");
            String lName = res.getString("lName");
            String email = res.getString("email");
            String phone = res.getString("phone");
            String username = res.getString("username");
            String password = res.getString("password");

            Date dateString= res.getDate("date");
            LocalDate date= LocalDate.parse(dateString.toString());

            Card card =  CardDao.getInstance().getByClient(id);
            Playlist playlist = PlaylistDao.getInstance().getPlaylistByClient(id);

            return new Client(id,fName,lName,email,phone,username,password,
                    card,date,playlist);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("error client");
            return null;
        }
    }

    @Override
    public Client getById(int id) {
//        Client client = new Client();
        try{
            String query = "select * from client where id = ?;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Client client = rowToObject(resultSet);

            return client;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Client> getTable() {
        ArrayList<Client> listClient = new ArrayList<>();
        try{
            String query = "select * from client;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Client client = rowToObject(resultSet);
                listClient.add(client);
            }
        }catch (Exception e){
            System.out.println("gh2");
            e.printStackTrace();
        }
        return listClient;
    }

    @Override
    public int insert(Client client) {
        if(client == null)
            return -1;
        clients.add(client);
        try{
            String query = "insert into client(id,fName,lName,email" +
                    ",phone,username,password,date) values " +
                    "(?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,client.getId());
            preparedStatement.setString(2,
                    client.getlName());
            preparedStatement.setString(3,
                    client.getfName());
            preparedStatement.setString(4,
                    client.getEmail());
            preparedStatement.setString(5,
                    client.getPhone());
            preparedStatement.setString(6,
                    client.getUsername());
            preparedStatement.setString(7,
                    client.getPassword());
            preparedStatement.setString(8,client.getDate());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return client.getId();
    }

    @Override
    public int update(Client client) {
        return 0;
    }

    @Override
    public void delete(Client client) {

    }
}
