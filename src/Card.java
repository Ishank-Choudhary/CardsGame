import java.util.*;
import java.util.Collections;
import java.lang.*;

public record Card(Suit suit, String face ,int rank) {
    public enum Suit {
        CLUB,DIAMOND,HEART,SPADE;
    }

    public char getImage(){
        char[] c = new char[]{9827, 9830, 9829, 9824};
        return c[this.ordinal()];
    }

}
