package klondike.controller;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToTableauPileController extends MoveController {

    private CardListIndex tableauPileIndex;

    protected WasteToTableauPileController(Game game) {
        super(game);
    }

    public void setTableauPileIndex(int tableauPileNumber) {
        this.tableauPileIndex = CardListIndex.tableauPileIndex(tableauPileNumber - 1);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public Error validate() {
        Error error = super.validateNotEmpty(CardListIndex.WASTE);
        if (error == null) {
            error = super.validateCardToAddToTableauPile(super.getCard(CardListIndex.WASTE), tableauPileIndex);
        }
        return error;
    }

    public void moveCardsFromWasteToTableauPile() {
        Card cardOnTopWaste = super.removeCardFromWaste();
        super.addCard(tableauPileIndex, cardOnTopWaste);
    }

}
