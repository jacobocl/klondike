package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.Game;
import klondike.model.GameState;

public abstract class Controller {

    private Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public GameState getState() {
        return game.getState();
    }

    public void setGameState(GameState state) {
        assert state != null;
        game.setGameState(state);
    }

    public Card getCardFromStock() {
        return game.getCardFromStock();
    }

    public Card getCardFromWaste() {
        return game.getCardFromWaste();
    }
    
    public List<Card> getVisibleCardsFromWaste() {
        return game.getVisibleCardsFromWaste();
    }

    public Card getCardFromFoundation(int foundation) {
        return game.getCardFromFoundation(foundation);
    }

    public Card getCardFromTableauPile(int tableauPile) {
        return game.getCardFromTableauPile(tableauPile);
    }
    
    public List<Card> getVisibleCardsTableauPile(int tableauPile) {
        return game.getVisibleCardsTableauPile(tableauPile);
    }
    
    public int getFlippedDownCardsFromTableauPile(int tableauPile) {
        return game.getFlippedDownCardsFromTableauPile(tableauPile);
    }

    public Card removeCardFromStock() {
        return game.removeCardFromStock();
    }

    public Card removeCardFromWaste() {
        return game.removeCardFromWaste();
    }

    public Card removeCardFromFoundation(int foundation) {
        return game.removeCardFromFoundation(foundation);
    }

    public Card removeCardFromTableauPile(int tableauPile) {
        return game.removeCardFromTableauPile(tableauPile);
    }

    public void addCardToStock(Card card) {
        assert card != null;
        game.addCardToStock(card);
    }

    public void addCardToWaste(Card card) {
        assert card != null;
        game.addCardToWaste(card);
    }

    public void addCardToFoundation(Card card, int foundation) {
        assert card != null;
        game.addCardToFoundation(card, foundation);
    }

    public void addCardToTableauPile(Card card, int tableauPile) {
        assert card != null;
        game.addCardToTableauPile(card, tableauPile);
    }

    public boolean isStockEmpty() {
        return game.isStockEmpty();
    }

    public boolean isWasteEmpty() {
        return game.isWasteEmpty();
    }

    public boolean isFoundationEmpty(int foundation) {
        return game.isFoundationEmpty(foundation);
    }

    public boolean isTableauPileEmpty(int tableauPile) {
        return game.isTableauPileEmpty(tableauPile);
    }

    public abstract void control();

}
