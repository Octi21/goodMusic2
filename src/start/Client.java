package start;

import java.util.*;


public class Client {
    private int id;
    private String fName, lName;
    private String email, phone;
    private Card card;

    public Client(int id, String fName, String lName, String email, String phone, Card card) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", card=" + card +
                '}';
    }
}
