package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class TableauPileToFoundationController extends MoveController {

    protected TableauPileToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
