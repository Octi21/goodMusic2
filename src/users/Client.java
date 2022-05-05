package users;

import start.Card;

public class Client extends User{

    protected Card card;

    public Client(String fName, String lName, String email, String phone, String username, String password, Card card) {
        super(fName, lName, email, phone, username, password);
        this.card = card;
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
}
