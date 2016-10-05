package klondike.controller;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.model.GameState;
import klondike.view.MenuView;

public abstract class MoveController extends Controller {

    protected MoveController(Game game) {
        super(game);
    }

    public abstract void accept(MenuView optionView);

    protected Error validateNotEmpty(CardListIndex cardListIndex) {
        if (super.isListOfCardsEmpty(cardListIndex)) {
            return Error.IS_EMPTY;
        }
        return null;
    }

    protected Error validateEmpty(CardListIndex cardListIndex) {
        if (!super.isListOfCardsEmpty(cardListIndex)) {
            return Error.IS_NOT_EMPTY;
        }
        return null;
    }

    protected Error validateisAce(Card card) {
        if (!card.isAce()) {
            return Error.CARD_NOT_SUITABLE_FOUNDATION;
        }
        return null;
    }

    protected Error validateCardToAddToFoundation(Card cardToAdd) {
        CardListIndex foundationIndex = CardListIndex.foundationIndex(cardToAdd.getSuit().ordinal());

        if (super.isListOfCardsEmpty(foundationIndex)) {
            if (cardToAdd.isAce()) {
                return null;
            } else {
                return Error.CARD_NOT_SUITABLE_FOUNDATION;
            }
        } else {
            Card cardOnTopFoundation = super.getCard(foundationIndex);
            if (!cardOnTopFoundation.sameSuit(cardToAdd) || !cardToAdd.isImmediateHigher(cardOnTopFoundation)) {
                return Error.CARD_NOT_SUITABLE_FOUNDATION;
            }
            return null;
        }
    }

    protected Error validateCardToAddToTableauPile(Card cardToAdd, CardListIndex tableauPileIndex) {

        if (super.isListOfCardsEmpty(tableauPileIndex)) {
            if (cardToAdd.isKing()) {
                return null;
            } else {
                return Error.CARD_NOT_SUITABLE_TABLEAU_PILE;
            }
        } else {
            Card lastCardTableauPile = super.getCard(tableauPileIndex);
            if (lastCardTableauPile.sameSuit(cardToAdd) || !lastCardTableauPile.isImmediateHigher(cardToAdd)) {
                return Error.CARD_NOT_SUITABLE_TABLEAU_PILE;
            }
            return null;
        }
    }

    protected Card removeCard(CardListIndex cardListIndex) {
        Card cardOnTopWaste = super.getCard(cardListIndex);
        super.removeCards(cardListIndex, 1);
        return cardOnTopWaste;
    }

    public void win() {
        super.setGameState(GameState.FINAL);
    }
}
