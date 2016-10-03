package klondike.controller;

import klondike.model.Game;

public abstract class MoveController extends Controller {

    protected MoveController(Game game) {
        // TODO: assert board != null;
        // TODO: this.board = board;
        super(game);
    }

}
