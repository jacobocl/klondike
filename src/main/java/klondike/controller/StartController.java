package klondike.controller;

import klondike.model.Card;
import klondike.model.Game;
import klondike.model.GameState;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        for (int i = 0; i < Game.NUM_TABLEAU_PILES; i++) {
            for (int j = 0; j <= i; j++) {
                Card card = this.removeCardFromStock();
                if (j==i) {
                    card.setFlippedUp(true);
                }
                this.addCardToTableauPile(card, i);
            }
        }
        this.setGameState(GameState.IN_GAME);
    }
}
