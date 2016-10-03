package klondike.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Stock extends CardList {

    public Stock() {
        super();
        List<Card> unorderedCards = new LinkedList<Card>();
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Number.values().length; j++) {
                unorderedCards.add(new Card(Suit.values()[i], Number.values()[j]));
            }
        }
        Collections.shuffle(unorderedCards);
        for (Card card : unorderedCards) {
            add(card);
        }
    }

    @Override
    public void add(Card card) {
        assert card != null;
        card.setFlippedUp(false);
        getCards().add(card);
    }

    @Override
    public Card get() {
        assert getCards().size() >= 1;
        return getCards().get(getCards().size() - 1);
    }

    @Override
    public Card remove() {
        assert getCards().size() >= 1;
        return getCards().remove(getCards().size() - 1);
    }

}
