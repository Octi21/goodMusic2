package users;

import card.Card;
import db.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class AdminDao implements Dao<Admin> {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static AdminDao singelton = null;

    private AdminDao()
    {
        admins = getTable();
    }

    public static AdminDao getInstance(){
        if(singelton == null)
        {
            singelton = new AdminDao();
        }
        return singelton;
    }


    @Override
    public Admin rowToObject(ResultSet res) {
        try{
            int id = res.getInt("id");
            String fName = res.getString("fName");
            String lName = res.getString("lName");
            String email = res.getString("email");
            String phone = res.getString("phone");
            String username = res.getString("username");
            String password = res.getString("password");

            int update = res.getInt("update");

            return new Admin(id,fName,lName,email,phone,username,password,update);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Admin getById(int id) {
        try{
            String query = "select * from admin where id = ?";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return rowToObject(resultSet);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Admin> getTable() {
        ArrayList<Admin> listAdmins = new ArrayList<>();
        try{
            String query = "select * from admin;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Admin admin = rowToObject(resultSet);
                listAdmins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listAdmins;
    }

    @Override
    public int insert(Admin admin) {
        if(admin == null)
            return -1;
        admins.add(admin);
        try{
            String query = "insert into client(id,fName,lName,email" +
                    ",phone,username,password,update) values " +
                    "(?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,admin.getId());
            preparedStatement.setString(2,
                    admin.getlName());
            preparedStatement.setString(3,
                    admin.getfName());
            preparedStatement.setString(4,
                    admin.getEmail());
            preparedStatement.setString(5,
                    admin.getPhone());
            preparedStatement.setString(6,
                    admin.getUsername());
            preparedStatement.setString(7,
                    admin.getPassword());
            preparedStatement.setInt(8,
                    admin.getUpdate());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return admin.getId();
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public void delete(Admin admin) {

    }
}
