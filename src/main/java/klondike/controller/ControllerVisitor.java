package klondike.controller;

public interface ControllerVisitor {

    public void visit(StartController startController);
    
    public void visit(OptionController optionController);
}
