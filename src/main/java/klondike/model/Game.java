package klondike.model;

import java.util.List;

public class Game {

    private Stock stock;

    private Waste waste;

    private Foundation[] foundations;

    private TableauPile[] tableau;

    private GameState state;

    public static int NUM_FOUNDATIONS = 4;

    public static int NUM_TABLEAU_PILES = 7;

    public Game() {
        stock = new Stock();
        waste = new Waste();
        foundations = new Foundation[NUM_FOUNDATIONS];
        for (int i = 0; i < NUM_FOUNDATIONS; i++) {
            foundations[i] = new Foundation();
        }
        tableau = new TableauPile[NUM_TABLEAU_PILES];
        for (int i = 0; i < NUM_TABLEAU_PILES; i++) {
            tableau[i] = new TableauPile();
        }
        state = GameState.INITIAL;
    }
    
    public GameState getState() {
        return state;
    }
    
    public void setGameState(GameState state){
        this.state = state;
    }

    public Card getCardFromStock() {
        return stock.get();
    }
    
    public Card getCardFromWaste() {
        return waste.get();
    }
    
    public List<Card> getVisibleCardsFromWaste() {
        return waste.getVisibleCards();
    }
    
    public Card getCardFromFoundation(int foundation) {
        assert foundation >= 0 && foundation < NUM_FOUNDATIONS;
        return foundations[foundation].get();
    }
    
    public Card getCardFromTableauPile(int tableauPile) {
        assert tableauPile >= 0 && tableauPile < NUM_TABLEAU_PILES;
        return tableau[tableauPile].get();
    }
    
    public List<Card> getVisibleCardsTableauPile(int tableauPile) {
        return tableau[tableauPile].getVisibleCards();
    }
    
    public Card removeCardFromStock() {
        return stock.remove();
    }
    
    public Card removeCardFromWaste() {
        return waste.remove();
    }
    
    public Card removeCardFromFoundation(int foundation) {
        assert foundation >= 0 && foundation < NUM_FOUNDATIONS;
        return foundations[foundation].remove();
    }
    
    public Card removeCardFromTableauPile(int tableauPile) {
        assert tableauPile >= 0 && tableauPile < NUM_TABLEAU_PILES;
        return tableau[tableauPile].remove();
    }
    
    public void addCardToStock(Card card) {
        stock.add(card);
    }
    
    public void addCardToWaste(Card card) {
        waste.add(card);
    }
    
    public void addCardToFoundation(Card card, int foundation) {
        assert foundation >= 0 && foundation < NUM_FOUNDATIONS;
        foundations[foundation].add(card);
    }
    
    public void addCardToTableauPile(Card card, int tableauPile) {
        assert tableauPile >= 0 && tableauPile < NUM_TABLEAU_PILES;
        tableau[tableauPile].add(card);
    }
    
    public boolean isStockEmpty() {
        return stock.isEmpty();
    }
    
    public boolean isWasteEmpty() {
        return waste.isEmpty();
    }
    
    public boolean isFoundationEmpty(int foundation) {
        assert foundation >= 0 && foundation < NUM_FOUNDATIONS;
        return foundations[foundation].isEmpty();
    }
    
    public boolean isTableauPileEmpty(int tableauPile) {
        assert tableauPile >= 0 && tableauPile < NUM_TABLEAU_PILES;
        return tableau[tableauPile].isEmpty();
    }

    public int getFlippedDownCardsFromTableauPile(int tableauPile) {
        assert tableauPile >= 0 && tableauPile < NUM_TABLEAU_PILES;
        return tableau[tableauPile].flippedDownCards();
    }
}
