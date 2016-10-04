package klondike.view;

import klondike.controller.Controller;
import klondike.model.CardListIndex;

public class BoardView {
    
    private Controller controller;

    public BoardView(Controller controller) {
        super();
        this.controller = controller;
    }

    public void write () {
        new StockView(controller).write("Baraja");
        new WasteView(controller).write("Descarte");
        for (int i = 0; i < CardListIndex.numberOfFoundations(); i++) {
            new FoundationView(controller, CardListIndex.foundationIndex(i)).write("Palo " + CardView.SUITS[i]);
        }
        for (int i = 0; i < CardListIndex.numberOfTableauPiles(); i++) {
            new TableauPileView(controller, CardListIndex.tableauPileIndex(i)).write("Escalera " + (i + 1));
        }
    }
}
