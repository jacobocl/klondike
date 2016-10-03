package klondike;

import klondike.controller.Controller;
import klondike.controller.StartController;
import klondike.model.Game;
import klondike.view.ControllerView;
import klondike.view.OptionView;

public class Klondike {

    private ControllerView controllerView;

    private OptionView optionView;

    public Klondike(ControllerView controllerView, OptionView optionView) {
        this.controllerView = controllerView;
        this.optionView = optionView;
    }

    public void play() {
        //TODO: Repensar
        Controller controller = new StartController(new Game());
        do {
            if (controller != null) {
                controllerView.interact(controller);
            }
            controller = optionView.getMoveController();
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Klondike(new ControllerView(), new OptionView()).play();
    }
}
