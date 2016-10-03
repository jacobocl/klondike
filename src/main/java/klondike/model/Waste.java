package klondike.model;

import java.util.List;

public class Waste extends CardList {
    
    private int visibleCards;

    public Waste() {
        super();
        visibleCards = 0;
    }

    @Override
    public void add(Card card) {
        assert card != null;
        card.setFlippedUp(true);
        getCards().add(card);
        visibleCards = 3;
    }

    @Override
    public Card get() {
        assert getCards().size() >= 1;
        return getCards().get(getCards().size() - 1);
    }

    @Override
    public Card remove() {
        assert getCards().size() >= 1;
        if (visibleCards > 1) {
            visibleCards--;
        }
        return getCards().remove(getCards().size() - 1);
    }

    public List<Card> getVisibleCards() {
        return getCards().subList(getCards().size() - visibleCards, getCards().size());
    }

}
