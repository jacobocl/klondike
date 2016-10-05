package klondike.controller;

import klondike.model.Game;
import klondike.model.GameState;
import klondike.view.MenuView;

public class ExitController extends MoveController {

    protected ExitController(Game game) {
        super(game);
    }

    @Override
    public void accept(MenuView optionView) {
        optionView.visit(this);
    }

    public void exit() {
        super.setGameState(GameState.FINAL);
    }

}
