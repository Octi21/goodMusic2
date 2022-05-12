package card;

import db.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CardDao implements Dao<Card> {
    private ArrayList<Card> cards = new ArrayList<>();
    private static CardDao singelton = null;


    private CardDao()
    {
        cards = getTable();
    }

    public static CardDao getInstance()
    {
        if(singelton == null)
            singelton = new CardDao();
        return singelton;
    }

    @Override
    public Card rowToObject(ResultSet res) {
        try{
            int id = res.getInt("id");
            String number = res.getString("number");
            String holderName = res.getString("holderName");
            int cvv = res.getInt("cvv");
            Date expDate = res.getDate("expDate");
            String iBan = res.getString("iBan");

            int idClient = res.getInt("idClient");

            return new Card(id,number,holderName,cvv,expDate,iBan,idClient);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Card getById(int id) {
        return null;
    }

    @Override
    public ArrayList<Card> getTable() {
        ArrayList<Card> listCard = new ArrayList<>();
        try {
            String query = "select * from card;";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Card card = rowToObject(resultSet);
                cards.add(card);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCard;
    }

    @Override
    public int insert(Card card) {
        if (card == null)
            return -1;
        cards.add(card);
        try{
            String query = "insert into card(id,number,holderName" +
                    "cvv,expDate,iBan,idClient) values(?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    Dao.conn.prepareStatement(query);
            preparedStatement.setInt(1,card.getId());
            preparedStatement.setString(2,
                    card.getNumber());
            preparedStatement.setString(3,
                    card.getHolderName());
            preparedStatement.setInt(4,card.getCvv());
            preparedStatement.setDate(5,
                    (java.sql.Date) card.getExpDate());
            preparedStatement.setString(6,
                    card.getiBan());
            preparedStatement.setInt(7,card.getIdClient());

            preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();

        }
        return card.getId();
    }

    @Override
    public int update(Card card) {
        return 0;
    }

    @Override
    public void delete(Card card) {

    }
}
