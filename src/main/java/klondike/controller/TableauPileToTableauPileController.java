package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.view.MenuView;

public class TableauPileToTableauPileController extends MoveController {

    private CardListIndex tableauPileOriginIndex;

    private CardListIndex tableauPileDestinationIndex;

    private int numberOfCards;

    protected TableauPileToTableauPileController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public void setTableauPileOriginIndex(int tableauPileOriginNumber) {
        tableauPileOriginIndex = CardListIndex.tableauPileIndex(tableauPileOriginNumber - 1);
    }

    public void setTableauPileDestinationIndex(int tableauPileDestinationNumber) {
        tableauPileDestinationIndex = CardListIndex.tableauPileIndex(tableauPileDestinationNumber - 1);
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public Error validate() {
        Error error = super.validateNotEmpty(tableauPileOriginIndex);
        if (error == null) {
            if (super.getVisibleCards(tableauPileOriginIndex) < numberOfCards) {
                error= Error.NOT_ENOUGH_CARDS_TABLEAU_PILE;
            } else {
                Card firstOriginTableauPileCard = super.getCards(tableauPileOriginIndex, numberOfCards).get(0);
                error = super.validateCardToAddToTableauPile(firstOriginTableauPileCard, tableauPileDestinationIndex);
            }
        }
        return error;
    }

    public void moveCardsFromTableauPileToTableauPile() {
        List<Card> cardsFromOriginTableauPile = super.getCards(tableauPileOriginIndex, numberOfCards);
        super.addCards(tableauPileDestinationIndex, cardsFromOriginTableauPile);
    }

}
