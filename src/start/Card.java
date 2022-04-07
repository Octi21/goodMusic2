package start;

import java.util.*;

public class Card {
    protected String number,holderName;
    protected int cvv;
    protected Date expDate;
    protected String iBan;

    public Card(String number, String holderName, int cvv, Date expDate, String iBan) {
        this.number = number;
        this.holderName = holderName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.iBan = iBan;
    }


    public String getNumber() {
        return number;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getCvv() {
        return cvv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public String getiBan() {
        return iBan;
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
