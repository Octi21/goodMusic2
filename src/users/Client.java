package users;

import card.Card;
import playlist.Playlist;

import java.time.LocalDate;

public class Client extends User{
    protected static int aux = 0;

    protected Card card;
    protected LocalDate date;
    protected Playlist playlist;

    public Client(int id,String fName, String lName, String email,
                  String phone, String username, String password,
                  Card card,LocalDate data,Playlist playlist)
    {
        super(id,fName, lName, email, phone, username, password);
        this.card = card;
        this.date = data;
        this.playlist = playlist;
    }

    public Client(String fName, String lName, String email,
                  String phone, String username, String password,
                  Card card, Playlist playlist) {
        super(fName, lName,  email,  phone,  username,  password);
        aux +=1;
        this.id = aux;

        this.card = card;
        this.playlist = playlist;
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
                ", playlist= " + playlist +
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

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
