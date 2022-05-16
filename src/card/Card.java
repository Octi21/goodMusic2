package card;

import java.time.LocalDate;
import java.util.*;

public class Card {
    protected static int aux = 0;

    protected int id;
    protected String number,holderName;
    protected int cvv;
    protected LocalDate expDate;
    protected int suma;

    protected int idClient;

    public Card(int id, String number, String holderName, int cvv, LocalDate expDate, int suma, int idClient) {
        this.id = id;
        this.number = number;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.suma = suma;

        this.idClient = idClient;
    }

    public Card(String number, String holderName, int cvv, LocalDate expDate, int suma, int idClient) {
        this.number = number;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.suma = suma;

        aux += 1;
        this.id = aux;

        this.idClient = idClient;
    }

    public Card() {
        this.id = -1;
        this.number = "";
        this.holderName = "";
        this.cvv = -1;
        this.expDate = LocalDate.parse("2000-02-02");
        this.suma = 0;

        this.idClient = -1;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Card.aux = aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate.toString();
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", holderName='" + holderName + '\'' +
                ", cvv=" + cvv +
                ", expDate=" + expDate +
                ", iBan='" + suma + '\'' +
                '}';
    }
}
