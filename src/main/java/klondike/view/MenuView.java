package klondike.view;

import klondike.controller.ExitController;
import klondike.controller.FoundationToTableauPileController;
import klondike.controller.MenuController;
import klondike.controller.MoveController;
import klondike.controller.StockToWasteController;
import klondike.controller.TableauPileToFoundationController;
import klondike.controller.TableauPileToTableauPileController;
import klondike.controller.WasteToFoundationController;
import klondike.controller.WasteToStockController;
import klondike.controller.WasteToTableauPileController;
import klondike.model.CardListIndex;
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
        new BoardView(menuController).write();
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
        klondike.controller.Error error = stockToWasteController.validateStockNotEmpty();
        if (error != null) {
            new IO().writeln(error.toString());
        } else {
            stockToWasteController.moveCardsFromStockToWaste();
        }
    }

    @Override
    public void visit(WasteToStockController wasteToStockController) {
        klondike.controller.Error error = wasteToStockController.validate();
        if (error != null) {
            new IO().writeln(error.toString());
        } else {
            wasteToStockController.moveCardsFromWasteToStock();
        }
    }

    @Override
    public void visit(WasteToFoundationController wasteToFoundationController) {
        klondike.controller.Error error = wasteToFoundationController.validate();
        if (error != null) {
            new IO().writeln(error.toString());
        } else {
            wasteToFoundationController.moveCardsFromWasteToFoundation();
            checkWin(wasteToFoundationController);
        }
    }

    @Override
    public void visit(WasteToTableauPileController wasteToTableauPileController) {
        int tableauPileNumber = new LimitedIntDialog("¿A qué escalera?", CardListIndex.numberOfTableauPiles()).read();
        wasteToTableauPileController.setTableauPileIndex(tableauPileNumber);
        klondike.controller.Error error = wasteToTableauPileController.validate();
        if (error != null) {
            new IO().writeln(error.toString());
        } else {
            wasteToTableauPileController.moveCardsFromWasteToTableauPile();
        }
    }

    @Override
    public void visit(TableauPileToFoundationController tableauPileToFoundationController) {
        int tableauPileNumber = new LimitedIntDialog("¿De qué escalera?", CardListIndex.numberOfTableauPiles()).read();
        tableauPileToFoundationController.setTableauPileIndex(tableauPileNumber);
        klondike.controller.Error error = tableauPileToFoundationController.validate();
        if (error != null) {
            new IO().writeln(error.toString());
        } else {
            tableauPileToFoundationController.moveCardsFromTableauPileToFoundation();
            checkWin(tableauPileToFoundationController);
        }
    }

    @Override
    public void visit(TableauPileToTableauPileController tableauPileToTableauPileController) {
        new IO().writeln(tableauPileToTableauPileController.getClass().getName());
    }

    @Override
    public void visit(FoundationToTableauPileController foundationToTableauPileController) {
        new IO().writeln(foundationToTableauPileController.getClass().getName());
    }

    @Override
    public void visit(ExitController exitController) {
        new IO().writeln(exitController.getClass().getName());
    }

    private void checkWin(MoveController moveController) {
        if (moveController.checkWin()) {
            moveController.win();
            new IO().writeln("¡¡ENHORABUENA, HAS GANADO!!");
        }
    }

}
