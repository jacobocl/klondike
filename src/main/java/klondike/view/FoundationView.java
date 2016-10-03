package klondike.view;

import klondike.controller.Controller;
import klondike.utils.IO;

public class FoundationView extends CardListView {

    int foundation;

    public FoundationView(Controller controller, int foundation) {
        super(controller);
        this.foundation = foundation;
    }

    @Override
    protected void ownView() {
        if (this.isFoundationEmpty(foundation)) {
            new IO().write(this.emptyCardList());
        } else {
            new CardView(getCardFromFoundation(foundation)).write();
        }
    }

}
