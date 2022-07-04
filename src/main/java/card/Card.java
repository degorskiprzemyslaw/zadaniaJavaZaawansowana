package card;

public class Card {

    private Rank rank;
    private Suit suit;


    public static void compareTwoCards(Card card1, Card card2){
        if(card1.rank.getNumericPower() > card2.rank.getNumericPower()){
            System.out.println("First card is bigger: " + card1);
        }
        else if(card1.rank.getNumericPower() < card2.rank.getNumericPower()){
            System.out.println("Second card is bigger: " + card2);
        }
        else{
            System.out.println("Cards are equal");
        }
    }



    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "card.Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
