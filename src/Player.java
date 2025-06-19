import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private String name;
    private int shuffleCount;

    public String getName() {
        return name;
    }

    public int getShuffleCount() {
        return shuffleCount;
    }

    public Player(String name, int shuffleCount) {
        this.name = name;
        this.shuffleCount = shuffleCount;
    }

    public static Card getRandomElement(List<Card> deck) {
        if (deck == null || deck.isEmpty()) {
            return null; // Or throw an IllegalArgumentException
        }
        Random random = new Random();
        int randomIndex = random.nextInt(deck.size());
        return deck.get(randomIndex);
    }

    public List<Card> drawCards(List<Card> deck, int numberOfDraws){
        List<Card> cardListForRank = new ArrayList<>(numberOfDraws);
        for(int i=0;i<numberOfDraws;i++){
            Card  c = getRandomElement(deck);
            cardListForRank.add(c);
            deck.remove(c);
        }
        return cardListForRank;
    }

}
