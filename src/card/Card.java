package card;

import java.util.*;

public class Card {
    protected static int aux = 0;

    protected int id;
    protected String number,holderName;
    protected int cvv;
    protected Date expDate;
    protected String iBan;

    protected int idClient;

    public Card(int id, String number, String holderName, int cvv, Date expDate, String iBan, int idClient) {
        this.id = id;
        this.number = number;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.iBan = iBan;

        this.idClient = idClient;
    }

    public Card(String number, String holderName, int cvv, Date expDate, String iBan, int idClient) {
        this.number = number;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.iBan = iBan;

        aux += 1;
        this.id = aux;

        this.idClient = idClient;
    }

    public Card() {
        this.id = -1;
        this.number = "";
        this.holderName = "";
        this.cvv = -1;
        this.expDate = new Date();
        this.iBan = "";

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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
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
                ", iBan='" + iBan + '\'' +
                '}';
    }
}
