package klondike;

import klondike.controller.Logic;
import klondike.controller.NotMoveController;
import klondike.view.KlondikeView;

public class Klondike {

    Logic logic;

    private KlondikeView klondikeView;

    public Klondike() {
        logic = new Logic();
        klondikeView = new KlondikeView();
    }

    public void play() {
        NotMoveController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                klondikeView.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }
}
