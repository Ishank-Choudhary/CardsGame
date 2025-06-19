import java.util.*;
import java.util.Collections;
import java.lang.*;

public record Card(Suit suit, String face ,int rank) {
    public enum Suit {
        CLUB,DIAMOND,HEART,SPADE;
    }

    public char getImage(){
        char[] c = new char[]{9827, 9830, 9829, 9824};
        return c[this.suit.ordinal()];
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", face='" + face + '\'' +
                ", rank=" + rank +
                '}';
    }

    public static List<Card> getFaceCard(){
        List<Card> listFace = new ArrayList<>(16);
        char[] faceCards = new char[]{'J','Q','K','A'};
        for(Card.Suit suit: Card.Suit.values()){
            for(int i=0;i<=3;i++){
                String face = String.valueOf(faceCards[i]);
                int rank = i+11;
                Card card = new Card(suit,face,rank);
                System.out.println("("+card.getImage()+")"+ card.face()+"("+card.rank()+")");
                listFace.add(card);
            }
            System.out.println();
        }
        return listFace;
    }

    public static List<Card> getNumericCard(){
        List<Card> listNumeric = new ArrayList<>(32);
        for(Card.Suit suit: Card.Suit.values()) {
            for (int i = 2; i <= 10; i++) {
                String face = String.valueOf(i);
                int rank = i + 2;
                Card card = new Card(suit, face, rank);
                System.out.println("("+card.getImage()+")"+ card.face()+"("+card.rank()+")");
                listNumeric.add(card);
            }
            System.out.println();///
        }
        return listNumeric;
    }

    public static List<Card> getStandardDeck(){
        List<Card> listAllCards = new ArrayList<>(52);
        List<Card> numericCards = getNumericCard();
        List<Card> faceCards = getFaceCard();
        listAllCards.addAll(numericCards);
        listAllCards.addAll(faceCards);

        return listAllCards;
    }
}
