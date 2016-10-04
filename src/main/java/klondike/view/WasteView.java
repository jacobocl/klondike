package klondike.view;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public class WasteView extends CardListView {

    public WasteView(Controller controller) {
        super(controller, CardListIndex.WASTE);
    }

    @Override
    protected void ownView() {
        if (this.isCardListEmpty()) {
            new IO().write(this.emptyCardList());
        } else {
            for (Card card : getVisibleCards()) {
                new CardView(card).write();
            }
        }
    }

}
