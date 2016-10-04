package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToStockController extends MoveController {

    protected WasteToStockController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
