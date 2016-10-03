package klondike.view;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.utils.IO;

public class TableauPileView extends CardListView {

    int tableauPile;

    public TableauPileView(Controller controller, int tableauPile) {
        super(controller);
        this.tableauPile = tableauPile;
    }

    @Override
    protected void ownView() {
        if (this.isTableauPileEmpty(tableauPile)) {
            new IO().write(this.emptyCardList());
        } else {
            for (int i = 0; i < getFlippedDownCardsFromTableauPile(tableauPile); i++) {
                new IO().write("[");
            }
            for (Card card : getVisibleCardsFromTableauPile(tableauPile)) {
                new CardView(card).write();
            }
        }
    }

}
