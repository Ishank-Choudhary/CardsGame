import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("Ishank",3);
        Player p2 = new Player("Himani",5);

        List<Card> deck = Card.getStandardDeck();
        int minShuffles = getMinShuffleCount(p1, p2);
        System.out.println(shuffleDeck(deck, minShuffles));

    }

    public static int getMinShuffleCount(Player p1, Player p2) {
        return Math.min(p1.getShuffleCount(), p2.getShuffleCount());
    }

    public static void shuffleDeck(List<Card> deck, int times) {
        if(times<=5) {
            for (int i = 0; i < times; i++) {
                Collections.shuffle(deck);
            }
        }else {
            System.out.println("Please keep the shuffle count less than or equal to 5");
        }
    }


}