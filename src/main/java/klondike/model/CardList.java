package klondike.model;

import java.util.ArrayList;
import java.util.List;

public abstract class CardList {

    private List<Card> cards;

    private int visibleCards;

    public CardList() {
        cards = new ArrayList<Card>();
        visibleCards = 0;
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void addCards(List<Card> cards) {
        assert cards != null;
        for (Card card : cards) {
            assert card != null;
        }
        this.cards.addAll(cards);
    }

    public List<Card> getCards(int numberOfCards) {
        assert cards.size() >= 1;
        assert numberOfCards <= cards.size();
        List<Card> cardsToGet = new ArrayList<Card>();
        for (int i = numberOfCards ; i > 0; i--) {
            cardsToGet.add(cards.get(cards.size() - i));
        }
        return cardsToGet;
    }

    public Card getCard() {
        assert cards.size() >= 1;
        return cards.get(cards.size() - 1);
    }

    public void remove(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            cards.remove(cards.size() - 1);
        }
    }

    protected void setVisibleCards(int visibleCards) {
        this.visibleCards = visibleCards;
    }

    public int getVisibleCards() {
        return visibleCards;
    }
    
    public int invisibleCards() {
        return this.size() - visibleCards;
    }
}
