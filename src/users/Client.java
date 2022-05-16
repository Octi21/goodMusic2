package users;

import card.Card;

import java.time.LocalDate;

public class Client extends User{
    protected static int aux = 0;

    protected Card card;
    protected LocalDate date;

    public Client(int id,String fName, String lName, String email, String phone, String username, String password, Card card,LocalDate data)
    {
        super(id,fName, lName, email, phone, username, password);
        this.card = card;
        this.date = data;
    }

    public Client(String fName, String lName, String email, String phone, String username, String password, Card card) {
        super(fName, lName,  email,  phone,  username,  password);
        aux +=1;
        this.id = aux;

        this.card = card;
        date = LocalDate.now();

    }

    @Override
    public String toString() {
        return "Client{" +

                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", card= " + card +
                ", data= " + date +
                '}';
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Client.aux = aux;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getDate() {
        return date.toString();
    }

    public void setData(LocalDate date) {
        this.date = date;
    }
}
