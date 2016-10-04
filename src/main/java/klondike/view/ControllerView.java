package klondike.view;

import klondike.controller.Controller;
import klondike.model.CardListIndex;
import klondike.utils.IO;

public class ControllerView {
    
    private IO io;
    
    private static String[] SUITS = {"♣", "♦", "♠", "♥"};
    
    public ControllerView() {
        io = new IO();
    }

    public void interact(Controller controller) {
        io.writeln("Interactuando con el controlador!!");
        controller.control();
        new StockView(controller).write("Baraja");
        new WasteView(controller).write("Descarte");
        for (int i = 0; i < CardListIndex.numberOfFoundations(); i++) {
            new FoundationView(controller, CardListIndex.foundationIndex(i)).write("Palo " + SUITS[i]);
        }
        for (int i = 0; i < CardListIndex.numberOfTableauPiles(); i++) {
            new TableauPileView(controller, CardListIndex.tableauPileIndex(i)).write("Escalera " + i);
        }
    }

}
