import java.util.ArrayList;
import java.util.Random;

public class Board {
    ArrayList<Square> squares = new ArrayList<>();
    public Board() {
        squares.add(new Square("START"));
        squares.add(new Square("PLACE 2", true, true, 100));
        squares.add(new Square("PLACE 3"));
        squares.add(new Square("PLACE 4", true, true, 100));
        squares.add(new Square("PLACE 5"));
        squares.add(new Square("PLACE 6"));
        squares.add(new Square("PLACE 7", true, true, 100));
        squares.add(new Square("PLACE 8"));
        squares.add(new Square("PLACE 9", true, true, 100));
        squares.add(new Square("PLACE 10", true, true, 100));
        squares.add(new Square("PLACE 11"));
        squares.add(new Square("PLACE 12", true, true, 100));
        squares.add(new Square("PLACE 13"));
        squares.add(new Square("PLACE 14", true, true, 100));
        squares.add(new Square("PLACE 15", true, true, 100));
        squares.add(new Square("PLACE 16"));
        squares.add(new Square("PLACE 17", true, true, 100));
        squares.add(new Square("PLACE 18"));
        squares.add(new Square("PLACE 19", true, true, 100));
        squares.add(new Square("PLACE 20", true, true, 100));
        squares.add(new Square("PLACE 21"));
        squares.add(new Square("PLACE 22", true, true, 100));
        squares.add(new Square("PLACE 23"));
        squares.add(new Square("PLACE 24", true, true, 100));
        squares.add(new Square("PLACE 25", true, true, 100));
        squares.add(new Square("PLACE 26"));
        squares.add(new Square("PLACE 27", true, true, 100));
        squares.add(new Square("PLACE 28", true, true, 100));
        squares.add(new Square("PLACE 29"));
        squares.add(new Square("PLACE 30", true, true, 100));
        squares.add(new Square("PLACE 31"));
        squares.add(new Square("PLACE 32", true, true, 100));
        squares.add(new Square("PLACE 33", true, true, 100));
        squares.add(new Square("PLACE 34"));
        squares.add(new Square("PLACE 35", true, true, 100));
        squares.add(new Square("PLACE 36"));
        squares.add(new Square("PLACE 37"));
        squares.add(new Square("PLACE 38", true, true, 100));
        squares.add(new Square("PLACE 39"));
        squares.add(new Square("PLACE 40", true, true, 100));
    }
    public int throwDice() {
        Random rand = new Random();
        return rand.nextInt(2, 13); // The bound is excluded
    }
}