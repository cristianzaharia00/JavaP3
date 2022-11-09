public class Square extends Property{
    public Square(String _name, boolean _buyable, boolean _upgradable, int _price) {
        name = _name;
        upgradable = _upgradable;
        price = _price;
        buyable = _buyable;
    }

    public Square(String _name) {
        name = _name;
        upgradable = false;
        price = 0;
        buyable = false;
    }
}
