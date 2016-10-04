package klondike.controller;

public enum Error {
    IS_EMPTY("El orígen está vacío"),
    IS_NOT_EMPTY("El destino no está vacío");

    private String message;

    Error(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
}
