package klondike.view;

import klondike.controller.Controller;
import klondike.model.Card;
import klondike.utils.IO;

public class WasteView extends CardListView {

    public WasteView(Controller controller) {
        super(controller);
    }

    @Override
    protected void ownView() {
        if (this.isWasteEmpty()) {
            new IO().write(this.emptyCardList());
        } else {
            for (Card card : getVisibleCardsFromWaste()) {
                new CardView(card).write();
            }
        }
    }

}
