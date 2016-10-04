package klondike.controller;

public interface NotMoveControllerVisitor {

    public void visit(StartController startController);
    
    public void visit(MenuController optionController);
}
