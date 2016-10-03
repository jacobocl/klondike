package klondike.model;

public enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public NumberDistance distance(Number number) {
        int distance = this.ordinal() - number.ordinal();
        switch (distance) {
        case 1:
            return NumberDistance.IMMEDIATE_LOWER;
        case -1:
            return NumberDistance.IMMEDIATE_HIGHER;
        default:
            return NumberDistance.NONE;
        }
    }
}
