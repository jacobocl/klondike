package klondike.model;

import java.util.List;

public class Foundation extends CardList {
    
    private static final int VISIBLE_CARDS = 1;

    public Foundation() {
        super();
        super.setVisibleCards(VISIBLE_CARDS);
    }

    @Override
    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            assert card.isFlippedUp();
        }
        super.addCards(cards);
    }

}
