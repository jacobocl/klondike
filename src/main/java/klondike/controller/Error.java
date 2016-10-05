package klondike.controller;

public enum Error {
    IS_EMPTY("El orígen está vacío"),
    IS_NOT_EMPTY("El destino no está vacío"),
    CARD_NOT_SUITABLE_FOUNDATION("La carta no puede añadirse a su palo"),
    CARD_NOT_SUITABLE_TABLEAU_PILE("La carta no puede añadirse a la escalera"),
    NOT_ENOUGH_CARDS_TABLEAU_PILE("No hay suficientes cartas en la escalera de origen");

    private String message;

    Error(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "¡¡ERROR!! " + message;
    }
}
