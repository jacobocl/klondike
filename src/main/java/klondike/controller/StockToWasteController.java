package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class StockToWasteController extends MoveController {

    protected StockToWasteController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
