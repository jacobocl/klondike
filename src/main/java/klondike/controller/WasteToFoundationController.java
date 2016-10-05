package klondike.controller;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToFoundationController extends MoveController {

    protected WasteToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public Error validate() {
        Error error = super.validateNotEmpty(CardListIndex.WASTE);
        if (error == null) {
            error = super.validateCardToAddToFoundation(super.getCard(CardListIndex.WASTE));
        }
        return error;

    }

    public void moveCardsFromWasteToFoundation() {
        Card cardOnTopWaste = super.removeCard(CardListIndex.WASTE);
        CardListIndex foundationIndex = CardListIndex.foundationIndex(cardOnTopWaste.getSuit().ordinal());
        super.addCard(foundationIndex, cardOnTopWaste);
    }

}
