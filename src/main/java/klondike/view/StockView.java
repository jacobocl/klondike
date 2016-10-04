package klondike.view;

import klondike.controller.Controller;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public class StockView extends CardListView {

    public StockView(Controller controller) {
        super(controller, CardListIndex.STOCK);
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
