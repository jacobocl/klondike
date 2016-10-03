package klondike.view;

import klondike.controller.Controller;
import klondike.utils.IO;

public class StockView extends CardListView {

    public StockView(Controller controller) {
        super(controller);
    }

    @Override
    protected void ownView() {
        if (this.isStockEmpty()) {
            new IO().write(this.emptyCardList());
        } else {
            new CardView(getCardFromStock()).write();
        }
    }

}
