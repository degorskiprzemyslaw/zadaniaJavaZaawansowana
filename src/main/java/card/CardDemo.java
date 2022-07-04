package card;
import javax.swing.*;
import java.util.ArrayList;

public class CardDemo {
    public static void main(String[] args) {
        Card card1 = new Card(Rank.SEVEN, Suit.HEART);
        Card card2 = new Card(Rank.SEVEN, Suit.CLUB);
        System.out.println(card1);
        System.out.println(card2);



        for(Rank rank : Rank.values()){
            System.out.println(rank);
        }
        Card.compareTwoCards(card1, card2);

        ArrayList<Card> spadesList = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            spadesList.add(new Card(rank, Suit.SPADE));
        }
        System.out.println(spadesList);

        ArrayList<Card> allCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                allCards.add(new Card(rank, suit));
            }
        }

        System.out.println(allCards);


    }

}
