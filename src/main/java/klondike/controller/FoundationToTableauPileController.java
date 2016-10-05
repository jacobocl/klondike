package klondike.controller;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class FoundationToTableauPileController extends MoveController {

    CardListIndex foundationIndex;

    CardListIndex tableauPileIndex;

    protected FoundationToTableauPileController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public void setFoundationIndex(int foundationNumber) {
        this.foundationIndex = CardListIndex.foundationIndex(foundationNumber - 1);
    }

    public void setTableauPileIndex(int tableauPileNumber) {
        this.tableauPileIndex = CardListIndex.tableauPileIndex(tableauPileNumber - 1);
    }

    public Error validate() {
        Error error = super.validateNotEmpty(foundationIndex);
        if (error == null) {
            error = super.validateCardToAddToTableauPile(super.getCard(foundationIndex), tableauPileIndex);
        }
        return error;
    }

    public void moveCardsFromFoundationToTableauPile() {
        Card cardOnTopFoundation = super.removeCard(foundationIndex);
        super.addCard(tableauPileIndex, cardOnTopFoundation);
    }

}
