package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToFoundationController extends MoveController {

    protected WasteToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
