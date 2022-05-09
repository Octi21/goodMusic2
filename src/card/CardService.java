package card;

import java.util.ArrayList;

public class CardService {
    private ArrayList<Card> cards;

    public CardService()
    {
        cards = new ArrayList<>();
    }

    public CardService(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
