package klondike.controller;

import klondike.model.Game;
import klondike.view.KlondikeView;

public abstract class NotMoveController extends Controller {

    public NotMoveController(Game game) {
        super(game);
    }

    public abstract void accept(KlondikeView klondikeView);
}
