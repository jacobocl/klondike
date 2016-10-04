package klondike.view;

import java.util.List;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public abstract class CardListView {
    
    private Controller controller;
    
    private CardListIndex cardListIndex;

    public CardListView(Controller controller, CardListIndex cardListIndex) {
        super();
        this.controller = controller;
        this.cardListIndex = cardListIndex;
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
    
    protected boolean isCardListEmpty() {
        return controller.isListOfCardsEmpty(cardListIndex);
    }
    
    public Card getCard() {
        return controller.getCard(cardListIndex);
    }
    
    public List<Card> getVisibleCards() {
        int visibleCards = controller.getVisibleCards(cardListIndex);
        return controller.getCards(cardListIndex, visibleCards);
    }
    
    public int flippedDownCards() {
        return controller.size(cardListIndex) - controller.getVisibleCards(cardListIndex);
    }

    protected abstract void ownView();
}
