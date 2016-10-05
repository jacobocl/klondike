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
        addCards(unorderedCards);
    }

    @Override
    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            card.setFlippedUp(false);
        }
        Collections.reverse(cards);
        super.addCards(cards);
    }
    
    @Override
    public List<Card> getCards(int numberOfCards) {
        List<Card> cardsToGet = super.getCards(numberOfCards);
        Collections.reverse(cardsToGet);
        return cardsToGet;
    }

}
