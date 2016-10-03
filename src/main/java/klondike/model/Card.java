package klondike.model;

public class Card {

    private Suit suit;

    private Number number;

    private boolean flippedUp;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
        this.flippedUp = false;
    }

    public boolean sameColor(Card card) {
        return this.suit.sameColor(card.suit);
    }

    public boolean sameSuit(Card card) {
        return this.suit == card.suit;
    }

    public boolean isAce() {
        return number == Number.ACE;
    }

    public boolean isKing() {
        return number == Number.KING;
    }

    public NumberDistance distanceBetweenCardNumber(Card card) {
        return this.number.distance(card.number);
    }
    
    public void setFlippedUp(boolean flippedUp) {
        this.flippedUp = flippedUp;
    }
    
    public boolean isFlippedUp() {
        return flippedUp;
    }

    public Suit getSuit() {
        return suit;
    }

    public Number getNumber() {
        return number;
    }
    
}
