package auxAdd;

import db.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuxAddDao implements Dao<AuxAdd> {
    private ArrayList<AuxAdd> auxAdds = new ArrayList<>();
    private static  AuxAddDao singelton = null;

    private AuxAddDao()
    {
        auxAdds = getTable();
    }
    public static AuxAddDao getInstance()
    {
        if(singelton == null)
        {
            singelton = new AuxAddDao();
        }
        return singelton;
    }

    @Override
    public AuxAdd rowToObject(ResultSet res) {
        try{
            int idAdd = res.getInt("idAdd");
            int idSong = res.getInt("idSong");
            int idPlaylist = res.getInt("idPlaylist");
            int idClient = res.getInt("idClient");

            return new AuxAdd(idAdd,idSong,idPlaylist,idClient);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AuxAdd getById(int id) {
        return null;
    }

    @Override
    public ArrayList<AuxAdd> getTable() {
        ArrayList<AuxAdd> listAuxAdd = new ArrayList<>();
        try{
            String query = "select * from auxAdd;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                AuxAdd auxadd = rowToObject(resultSet);
                listAuxAdd.add(auxadd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listAuxAdd;
    }

    @Override
    public int insert(AuxAdd auxAdd) {
        if(auxAdd == null)
            return -1;
        auxAdds.add(auxAdd);
        try{
            String query ="insert into auxAdd(idAdd,idSong,idPlaylist,idClient) " +
                    "values(?,?,?,?);";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,auxAdd.getIdAdd());
            preparedStatement.setInt(2,auxAdd.getIdSong());
            preparedStatement.setInt(3,auxAdd.getIdPlaylist());
            preparedStatement.setInt(4,auxAdd.getIdClient());
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return auxAdd.getIdAdd();
    }

    @Override
    public int update(AuxAdd auxAdd) {
        return 0;
    }

    @Override
    public void delete(AuxAdd auxAdd) {

    }

    public int getLastId()
    {
        return auxAdds.get(auxAdds.size()-1).getIdAdd();
    }

    public ArrayList<AuxAdd> getAuxAdds() {
        return auxAdds;
    }

    public void setAuxAdds(ArrayList<AuxAdd> auxAdds) {
        this.auxAdds = auxAdds;
    }
}
