package klondike.controller;

import klondike.model.Game;
import klondike.view.MenuView;

public abstract class MoveController extends Controller {

    protected MoveController(Game game) {
        super(game);
    }

    public abstract void accept(MenuView optionView);
}
