package klondike.model;

public enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public boolean isImmediateHigher(Number number) {
        assert number != null;
        int distance = this.ordinal() - number.ordinal();
        return distance == 1;
    }
}
