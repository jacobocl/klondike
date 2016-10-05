package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToStockController extends MoveController {

    protected WasteToStockController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }
    
    public Error validate() {
        Error error = super.validateEmpty(CardListIndex.STOCK);
        if (error == null) {
            error = super.validateNotEmpty(CardListIndex.WASTE);
        }
        return error;
    }

    public void moveCardsFromWasteToStock() {
        int cardsInWaste = super.size(CardListIndex.WASTE);
        List<Card> cardsRetrievedFromWaste = super.getCards(CardListIndex.WASTE, cardsInWaste);
        super.removeCards(CardListIndex.WASTE, cardsInWaste);
        super.addCards(CardListIndex.STOCK, cardsRetrievedFromWaste);
    }

}
