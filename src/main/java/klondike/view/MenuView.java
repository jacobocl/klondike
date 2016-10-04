package klondike.view;

import klondike.controller.MenuController;
import klondike.controller.StockToWasteController;
import klondike.controller.MoveControllerVisitor;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;

public class MenuView implements MoveControllerVisitor {

    private MenuController menuController;

    public MenuView(MenuController optionController) {
        this.menuController = optionController;
    }

    public void interact() {
        IO io = new IO();
        io.writeln("---------------------------");
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Salir");
        int optionSelected = new LimitedIntDialog("Elige una opción", MenuController.NUMBER_OF_CONTROLLERS).read();

        menuController.getMoveController(optionSelected).accept(this);
    }

    @Override
    public void visit(StockToWasteController stockToWasteController) {
        new IO().writeln("StockToWasteController");
    }

}
