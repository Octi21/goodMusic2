package users;

import card.Card;

public class Client extends User{
    protected static int aux = 0;

    protected Card card;

    public Client(int id,String fName, String lName, String email, String phone, String username, String password, Card card) {
        super(id,fName, lName, email, phone, username, password);
        this.card = card;
    }

    public Client(String fName, String lName, String email, String phone, String username, String password, Card card) {
        super(fName, lName,  email,  phone,  username,  password);
        aux +=1;
        this.id = aux;

    }

    @Override
    public String toString() {
        return "Client{" +
                "card=" + card +
                ", id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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
}
