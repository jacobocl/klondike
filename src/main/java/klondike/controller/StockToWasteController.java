package klondike.controller;

import klondike.model.Game;
import klondike.view.OptionView;

public class StockToWasteController extends MoveController {

    protected StockToWasteController(Game game) {
        super(game);
    }

    @Override
    public void accept(OptionView optionView) {
        optionView.visit(this);
    }

}
