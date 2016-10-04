package klondike.view;

import klondike.controller.NotMoveControllerVisitor;
import klondike.controller.NotMoveController;
import klondike.controller.MenuController;
import klondike.controller.StartController;

public class KlondikeView implements NotMoveControllerVisitor {

    public void interact(NotMoveController controller) {
        controller.accept(this);
        new BoardView(controller).write();
    }

    @Override
    public void visit(StartController startController) {
        startController.initialiceGame();
    }

    @Override
    public void visit(MenuController optionController) {
        new MenuView(optionController).interact();
    }

}
