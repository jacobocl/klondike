package klondike.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Map<CardListIndex, CardList> listsOfCards;

    private GameState state;

    private static final int CARDS_IN_FOUNDATION_MAX = 13;

    public Game() {
        listsOfCards = new HashMap<CardListIndex, CardList>();
        listsOfCards.put(CardListIndex.STOCK, new Stock());
        listsOfCards.put(CardListIndex.WASTE, new Waste());
        for (int i = 0; i < CardListIndex.numberOfFoundations(); i++) {
            listsOfCards.put(CardListIndex.foundationIndex(i), new Foundation());
        }
        for (int i = 0; i < CardListIndex.numberOfTableauPiles(); i++) {
            listsOfCards.put(CardListIndex.tableauPileIndex(i), new TableauPile());
        }
        state = GameState.INITIAL;
    }

    public GameState getGameState() {
        return state;
    }

    public void setGameState(GameState state) {
        this.state = state;
    }

    public Card getCard(CardListIndex cardListIndex) {
        return listsOfCards.get(cardListIndex).getCard();
    }

    public List<Card> getCards(CardListIndex cardListIndex, int numberOfCards) {
        return listsOfCards.get(cardListIndex).getCards(numberOfCards);
    }

    public void removeCards(CardListIndex cardListIndex, int numberOfCards) {
        listsOfCards.get(cardListIndex).remove(numberOfCards);
    }

    public void addCard(CardListIndex cardListIndex, Card card) {
        assert card != null;
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(card);
        listsOfCards.get(cardListIndex).addCards(cardList);
    }

    public void addCards(CardListIndex cardListIndex, List<Card> cards) {
        assert cards != null;
        listsOfCards.get(cardListIndex).addCards(cards);
    }

    public boolean isListOfCardsEmpty(CardListIndex cardListIndex) {
        return listsOfCards.get(cardListIndex).isEmpty();
    }

    public int getVisibleCards(CardListIndex cardListIndex) {
        return listsOfCards.get(cardListIndex).getVisibleCards();
    }

    public int size(CardListIndex cardListIndex) {
        return listsOfCards.get(cardListIndex).size();
    }

    public boolean checkWin() {
        CardList foundation1 = listsOfCards.get(CardListIndex.FOUNDATION_1);
        CardList foundation2 = listsOfCards.get(CardListIndex.FOUNDATION_2);
        CardList foundation3 = listsOfCards.get(CardListIndex.FOUNDATION_3);
        CardList foundation4 = listsOfCards.get(CardListIndex.FOUNDATION_4);
        return foundation1.size() == CARDS_IN_FOUNDATION_MAX && foundation2.size() == CARDS_IN_FOUNDATION_MAX && foundation3.size() == CARDS_IN_FOUNDATION_MAX && foundation4.size() == CARDS_IN_FOUNDATION_MAX;
    }
}
