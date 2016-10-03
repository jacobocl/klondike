package klondike.model;

import java.util.List;

public class TableauPile extends CardList {
    
    int visibleCards;

    public TableauPile() {
        super();
        visibleCards = 0;
    }

    @Override
    public void add(Card card) {
        assert card != null;
        getCards().add(card);
        if (card.isFlippedUp()) {
            visibleCards++;
        }
    }

    @Override
    public Card get() {
        assert getCards().size() >= 1;
        return getCards().get(getCards().size() - 1);
    }

    @Override
    public Card remove() {
        assert getCards().size() >= 1;
        Card card = getCards().remove(getCards().size() - 1);
        if (!this.isEmpty()) {
            visibleCards--;
            this.get().setFlippedUp(true);
        }
        return card;
    }

    public List<Card> getVisibleCards() {
        return getCards().subList(flippedDownCards(), getCards().size());
    }

    public int flippedDownCards() {
        return getCards().size() - visibleCards;
    }

}
