package klondike.model;

import java.util.List;

public class TableauPile extends CardList {

    private static final int MIN_VISIBLE_CARDS = 0;

    public TableauPile() {
        super();
    }

    @Override
    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            if (card.isFlippedUp()) {
                super.setVisibleCards(super.getVisibleCards() + 1);
            }
        }
        super.addCards(cards);
    }

    @Override
    public List<Card> getCards(int numberOfCards) {
        assert numberOfCards <= super.getVisibleCards();
        return super.getCards(numberOfCards);
    }

    @Override
    public void remove(int numberOfCards) {
        assert numberOfCards <= super.getVisibleCards();
        super.remove(numberOfCards);
        super.setVisibleCards(super.getVisibleCards() - numberOfCards);
        if (super.getVisibleCards() == MIN_VISIBLE_CARDS && !this.isEmpty()) {
            this.getCard().setFlippedUp(true);
            super.setVisibleCards(super.getVisibleCards() + 1);
        }
    }
}
