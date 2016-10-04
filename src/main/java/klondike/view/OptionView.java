package klondike.view;

import klondike.controller.OptionController;
import klondike.controller.StockToWasteController;
import klondike.controller.MoveControllerVisitor;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;

public class OptionView implements MoveControllerVisitor {

    private OptionController optionController;
    
    public OptionView(OptionController optionController) {
        this.optionController = optionController;
    }

    public void interact() {
        IO io = new IO();
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Salir");
        int optionSelected = new LimitedIntDialog("Elige una opción", OptionController.NUMBER_OF_CONTROLLERS).read();
        
        optionController.getMoveController(optionSelected).accept(this);
    }

    @Override
    public void visit(StockToWasteController stockToWasteController) {
        
    }

}
