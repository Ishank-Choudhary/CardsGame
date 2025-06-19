import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("Ishank",3);
        Player p2 = new Player("Himani",5);

        List<Card> deck = Card.getStandardDeck();
        int minShuffles = getMinShuffleCount(p1, p2);
        shuffleDeck(deck, minShuffles);

        List<Card> p1Hand = p1.drawCards(deck, 5);
        List<Card> p2Hand = p2.drawCards(deck, 5);

        // Print each player's hand
        System.out.println(p1.getName() + ": " + p1Hand);
        System.out.println(p2.getName() + ": " + p2Hand);

        System.out.println(decideWinner(p1, p1Hand, p2, p2Hand));

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

    public static String decideWinner(Player p1, List<Card> hand1, Player p2, List<Card> hand2) {
        int score1 = hand1.stream().mapToInt(Card::rank).sum();
        int score2 = hand2.stream().mapToInt(Card::rank).sum();

        if (score1 > score2) {
            return p1.getName() + " wins with " + score1 + " points!";
        } else if (score2 > score1) {
            return p2.getName() + " wins with " + score2 + " points!";
        } else {
            return "It's a tie! Both scored " + score1;
        }
    }

}