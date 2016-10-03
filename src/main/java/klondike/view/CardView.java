package klondike.view;

import klondike.model.Card;
import klondike.utils.IO;

public class CardView {

    private static final String[] NUMBERS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private static final String[] SUITS = {"♣", "♦", "♠", "♥"};

    private Card card;

    public CardView(Card card) {
        this.card = card;
    }

    public void write() {
        new IO().write(this.cardToString());
    }

    public void writeln() {
        new IO().writeln(this.cardToString());
    }

    private String cardToString() {
        String number = "X";
        String suit = "X";
        if (card.isFlippedUp()) {
            number = NUMBERS[card.getNumber().ordinal()];
            suit = SUITS[card.getSuit().ordinal()];
        }
        return "[" + number + "," + suit + "]";
    }
}
