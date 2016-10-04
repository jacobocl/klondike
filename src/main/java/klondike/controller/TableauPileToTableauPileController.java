package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public class TableauPileToTableauPileController extends MoveController {

    protected TableauPileToTableauPileController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

}
