package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.model.GameState;

public abstract class Controller {

    private Game game;

    public Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    public GameState getState() {
        return game.getState();
    }

    public void setGameState(GameState state) {
        game.setGameState(state);
    }

    public Card getCard(CardListIndex cardListIndex) {
        return game.getCard(cardListIndex);
    }

    public List<Card> getCards(CardListIndex cardListIndex, int numberOfCards) {
        return game.getCards(cardListIndex, numberOfCards);
    }

    public void removeCards(CardListIndex cardListIndex, int numberOfCards) {
        game.removeCards(cardListIndex, numberOfCards);
    }

    public void addCard(CardListIndex cardListIndex, Card card) {
        game.addCard(cardListIndex, card);
    }

    public void addCards(CardListIndex cardListIndex, List<Card> cards) {
        game.addCards(cardListIndex, cards);
    }

    public boolean isListOfCardsEmpty(CardListIndex cardListIndex) {
        return game.isListOfCardsEmpty(cardListIndex);
    }

    public int getVisibleCards(CardListIndex cardListIndex) {
        return game.getVisibleCards(cardListIndex);
    }

    public int size(CardListIndex cardListIndex) {
        return game.size(cardListIndex);
    }

}
