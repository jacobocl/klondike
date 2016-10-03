package klondike.view;

import klondike.controller.MoveController;
import klondike.utils.LimitedIntDialog;

public class OptionView {

    private MoveController[] controllers;

    private static int numberOfControllers = 8;

    public OptionView() {
        controllers = new MoveController[numberOfControllers];
        // TODO: Add controllers for each option
    }

    public MoveController getMoveController() {
        int optionSelected = new LimitedIntDialog("Elige una opción", 9).read();

        if (optionSelected <= numberOfControllers) {
            return controllers[optionSelected - 1];
        }

        return null;
    }

}
