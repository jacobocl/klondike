package klondike.model;

public enum Suit {
    CLUB, DIAMOND, SPADE, HEART;

    public boolean sameColor(Suit suit) {
        assert suit != null;
        return (this.ordinal() % 2) == (suit.ordinal() % 2);
    }

}
