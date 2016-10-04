package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class WasteToTableauPileController extends MoveController {

    protected WasteToTableauPileController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
