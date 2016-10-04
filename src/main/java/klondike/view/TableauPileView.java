package klondike.view;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public class TableauPileView extends CardListView {

    public TableauPileView(Controller controller, CardListIndex tableauPile) {
        super(controller, tableauPile);
    }

    @Override
    protected void ownView() {
        if (this.isCardListEmpty()) {
            new IO().write(this.emptyCardList());
        } else {
            for (int i = 0; i < flippedDownCards(); i++) {
                new IO().write("[");
            }
            for (Card card : getVisibleCards()) {
                new CardView(card).write();
            }
        }
    }

}
