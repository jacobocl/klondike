package klondike.model;

import java.util.List;

public class Waste extends CardList {
    
    private static final int MIN_VISIBLE_CARDS = 1;
    
    private static final int MAX_VISIBLE_CARDS = 3;

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
        super.setVisibleCards(MAX_VISIBLE_CARDS);
    }
    
    @Override
    public List<Card> getCards(int numberOfCards) {
        assert numberOfCards <= super.getVisibleCards();
        return super.getCards(numberOfCards);
    }

    @Override
    public void remove(int numberOfCards) {
        assert numberOfCards <= super.getVisibleCards();
        if (super.getVisibleCards() - numberOfCards > MIN_VISIBLE_CARDS) {
            super.setVisibleCards(super.getVisibleCards() - numberOfCards);
        } else {
            super.setVisibleCards(MIN_VISIBLE_CARDS);
        }
    }

}
