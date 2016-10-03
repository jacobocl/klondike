package klondike.model;

import java.util.ArrayList;
import java.util.List;

public abstract class CardList {

    private List<Card> cards;

    public CardList() {
        this.cards = new ArrayList<Card>();
    }

    protected List<Card> getCards() {
        return cards;
    }

    public int size() {
        return cards.size();
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public abstract void add(Card card);

    public abstract Card get();

    public abstract Card remove();
}
