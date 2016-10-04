package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class StockToWasteController extends MoveController {
    
    private static int CARDS_FROM_STOCK = 3;

    protected StockToWasteController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public void moveCardsFromStockToWaste() {
        int cardsInStock = super.size(CardListIndex.STOCK);
        List<Card> cardsRetrievedFromStock;
        int numberOfCardsToGet;
        if (cardsInStock > CARDS_FROM_STOCK) {
            numberOfCardsToGet = CARDS_FROM_STOCK;
        } else {
            numberOfCardsToGet = cardsInStock;
        }
        cardsRetrievedFromStock = super.getCards(CardListIndex.STOCK, numberOfCardsToGet);
        super.removeCards(CardListIndex.STOCK, numberOfCardsToGet);
        for (Card card : cardsRetrievedFromStock) {
            card.setFlippedUp(true);
        }
        super.addCards(CardListIndex.WASTE, cardsRetrievedFromStock);
    }
    
    public Error validateStock() {
        if (super.isListOfCardsEmpty(CardListIndex.STOCK)) {
            return Error.IS_EMPTY;
        }
        return null;
    }

}
