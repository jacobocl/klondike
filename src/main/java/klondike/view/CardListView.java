package klondike.view;

import java.util.List;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.utils.IO;

public abstract class CardListView {
    
    private Controller controller;

    public CardListView(Controller controller) {
        super();
        this.controller = controller;
    }

    public void write(String title) {
        IO io = new IO();
        io.write(title + ": ");
        ownView();
        io.writeln();
    }
    
    protected String emptyCardList() {
        return "<Vacío>";
    }
    
    protected boolean isStockEmpty() {
        return controller.isStockEmpty();
    }
    
    protected boolean isWasteEmpty() {
        return controller.isWasteEmpty();
    }
    
    protected boolean isFoundationEmpty(int foundation) {
        return controller.isFoundationEmpty(foundation);
    }
    
    protected boolean isTableauPileEmpty(int tableau) {
        return controller.isTableauPileEmpty(tableau);
    }
    
    public Card getCardFromStock() {
        return controller.getCardFromStock();
    }
    
    public List<Card> getVisibleCardsFromWaste() {
        return controller.getVisibleCardsFromWaste();
    }

    public Card getCardFromWaste() {
        return controller.getCardFromWaste();
    }

    public Card getCardFromFoundation(int foundation) {
        return controller.getCardFromFoundation(foundation);
    }

    public Card getCardFromTableauPile(int tableauPile) {
        return controller.getCardFromTableauPile(tableauPile);
    }
    
    public List<Card> getVisibleCardsFromTableauPile(int tableauPile) {
        return controller.getVisibleCardsTableauPile(tableauPile);
    }
    
    public int getFlippedDownCardsFromTableauPile(int tableauPile) {
        return controller.getFlippedDownCardsFromTableauPile(tableauPile);
    }

    protected abstract void ownView();
}
