package klondike.view;

import klondike.controller.Controller;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public class FoundationView extends CardListView {

    public FoundationView(Controller controller, CardListIndex foundation) {
        super(controller, foundation);
    }

    @Override
    protected void ownView() {
        if (this.isCardListEmpty()) {
            new IO().write(this.emptyCardList());
        } else {
            new CardView(getCard()).write();
        }
    }

}
