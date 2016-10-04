package klondike.view;

import klondike.controller.ControllerVisitor;
import klondike.controller.NotMoveController;
import klondike.controller.OptionController;
import klondike.controller.StartController;

public class KlondikeView implements ControllerVisitor {

    public void interact(NotMoveController controller) {
        controller.accept(this);
        new BoardView(controller).write();
    }

    @Override
    public void visit(StartController startController) {
        startController.initialiceGame();
    }

    @Override
    public void visit(OptionController optionController) {
        new OptionView(optionController).interact();
    }

}
