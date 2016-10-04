package klondike.controller;

import java.util.List;

import klondike.model.Card;
import klondike.model.CardListIndex;
import klondike.model.Game;
import klondike.model.GameState;
import klondike.view.KlondikeView;

public class StartController extends NotMoveController {

    public StartController(Game game) {
        super(game);
    }

    public void initialiceGame() {
        for (int i = 0; i < CardListIndex.numberOfTableauPiles(); i++) {
            List<Card> cards = this.getCards(CardListIndex.STOCK, i + 1);
            this.removeCards(CardListIndex.STOCK, i + 1);
            cards.get(cards.size() - 1).setFlippedUp(true);
            this.addCards(CardListIndex.tableauPileIndex(i), cards);
        }
        this.setGameState(GameState.IN_GAME);
    }

    @Override
    public void accept(KlondikeView klondikeView) {
        klondikeView.visit(this);
    }
}
