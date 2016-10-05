package klondike.controller;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class TableauPileToFoundationController extends MoveController {
    
    private CardListIndex tableauPileIndex;

    protected TableauPileToFoundationController(Game game) {
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
        Error error = super.validateNotEmpty(tableauPileIndex);
        if (error == null) {
            error = super.validateCardToAddToFoundation(super.getCard(tableauPileIndex));
        }
        return error;
    }

    public void moveCardsFromTableauPileToFoundation() {
        Card lastCardTableauPile = super.removeCard(tableauPileIndex);
        CardListIndex foundationIndex = CardListIndex.foundationIndex(lastCardTableauPile.getSuit().ordinal());
        super.addCard(foundationIndex, lastCardTableauPile);
    }

}
