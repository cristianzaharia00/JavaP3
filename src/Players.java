public class Players {
    public String name;
    public String colour;
    public String pawn_shape;
    public int cash;
    public int board_position;
    public int id;
    public int property_value=0;

    public Players(String _name, String _colour, String _pawn_shape, int _id) {
        name = _name;
        colour = _colour;
        pawn_shape = _pawn_shape;
        cash = 0;
        board_position = 1;
        id = _id;
    }
}