package klondike.controller;

import klondike.model.Game;

public class Logic {

        private Game game;
        
        private StartController startController;

        private OptionController optionController;

        public Logic() {
            game = new Game();
            startController = new StartController(game);
            optionController = new OptionController(game);
        }

        public NotMoveController getController() {
            switch (game.getState()){
            case INITIAL:
                return startController;
            case IN_GAME:
                return optionController;
            case FINAL:
            default:
                return null;
            }
        }
}
