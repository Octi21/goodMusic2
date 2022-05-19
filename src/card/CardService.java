package card;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CardService {
    private static ArrayList<Card> cards = new ArrayList<>();
    private static CardService singelton = null;

    private CardService()
    {
        cards = CardDao.getInstance().getTable();
    }

    public static CardService getInstance() {
        if(singelton == null)
        {
            singelton = new CardService();
        }
        return singelton;
    }

    public int getLastId(){
        int n = cards.size();
        if (n == 0)
            return 0;
        else
            return cards.get(n-1).getId();
    }

    public Card create(int idClient)
    {
//        protected String number,holderName;
//        protected int cvv;
//        protected LocalDate expDate;
//        protected int suma;
        Card.setAux(getLastId());

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");;

        System.out.println("CardInfo: ");

        System.out.println("number: ");
        String number = scanner.next();
        System.out.println("holderName: ");
        String holderName = scanner.next();
        System.out.println("cvv: ");
        int cvv = scanner.nextInt();

        System.out.println("date: ");
        String auxdate = scanner.next();
        LocalDate date = LocalDate.parse(auxdate);
        System.out.println("suma: ");
        int suma = scanner.nextInt();

        Card card = new Card(number,holderName,cvv,date,suma,idClient);
        CardDao.getInstance().insert(card);
        cards.add(card);

        return card;
    }




    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        CardService.cards = cards;
    }
}

