package klondike.model;

import java.util.List;

public class Waste extends CardList {
    
    private static final int MIN_VISIBLE_CARDS = 1;

    public Waste() {
        super();
        super.setVisibleCards(MIN_VISIBLE_CARDS);
    }

    @Override
    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            assert card.isFlippedUp();
        }
        super.addCards(cards);
        super.setVisibleCards(cards.size());
    }
    
    @Override
    public List<Card> getCards(int numberOfCards) {
        return super.getCards(numberOfCards);
    }

    @Override
    public void remove(int numberOfCards) {
        if (super.getVisibleCards() - numberOfCards > MIN_VISIBLE_CARDS) {
            super.setVisibleCards(super.getVisibleCards() - numberOfCards);
        } else {
            super.setVisibleCards(MIN_VISIBLE_CARDS);
        }
        super.remove(numberOfCards);
    }

}
