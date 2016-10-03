package klondike.view;

import klondike.controller.Controller;
import klondike.model.Game;
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
        for (int i = 0; i < Game.NUM_FOUNDATIONS; i++) {
            new FoundationView(controller, i).write("Palo " + SUITS[i]);
        }
        for (int i = 0; i < Game.NUM_TABLEAU_PILES; i++) {
            new TableauPileView(controller, i).write("Escalera " + i);
        }
    }

}
