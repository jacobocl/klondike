package klondike.model;

public enum Suit {
    CLUB, DIAMOND, SPADE, HEART;

    public boolean sameColor(Suit suit) {
        return (this.ordinal() % 2) == (suit.ordinal() % 2);
    }

}
