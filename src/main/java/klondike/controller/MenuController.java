package klondike.controller;

import klondike.model.Game;
import klondike.view.KlondikeView;

public class MenuController extends NotMoveController {
    
    private MoveController[] controllers;

    public static int NUMBER_OF_CONTROLLERS = 8;

    public MenuController(Game game) {
        super(game);
        controllers = new MoveController[NUMBER_OF_CONTROLLERS];
        controllers[0] = new StockToWasteController(game);
        controllers[1] = new WasteToStockController(game);
        controllers[2] = new WasteToFoundationController(game);
        controllers[3] = new WasteToTableauPileController(game);
        controllers[4] = new TableauPileToFoundationController(game);
        controllers[5] = new TableauPileToTableauPileController(game);
        controllers[6] = new FoundationToTableauPileController(game);
        controllers[7] = new ExitController(game);
    }

    public MoveController getMoveController(int option) {
        assert option > 0 && option <= NUMBER_OF_CONTROLLERS;
        return controllers[option - 1];
    }

    @Override
    public void accept(KlondikeView klondikeView) {
        klondikeView.visit(this);
    }
}
