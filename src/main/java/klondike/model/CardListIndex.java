package klondike.model;

public enum CardListIndex {
    STOCK, WASTE, FOUNDATION_1, FOUNDATION_2, FOUNDATION_3, FOUNDATION_4,
    TABLEAU_PILE_1, TABLEAU_PILE_2, TABLEAU_PILE_3, TABLEAU_PILE_4, TABLEAU_PILE_5, TABLEAU_PILE_6, TABLEAU_PILE_7;

    public int stocksOrigin() {
        return 0;
    }

    public static int numberOfFoundations() {
        return TABLEAU_PILE_1.ordinal() - FOUNDATION_1.ordinal();
    }

    public static int numberOfTableauPiles() {
        return CardListIndex.values().length - TABLEAU_PILE_1.ordinal();
    }

    public static CardListIndex foundationIndex(int foundation) {
        assert foundation >= 0 && foundation < numberOfFoundations();
        return CardListIndex.values()[FOUNDATION_1.ordinal() + foundation];
    }

    public static CardListIndex tableauPileIndex(int tableauPile) {
        assert tableauPile >= 0 && tableauPile < numberOfTableauPiles();
        return CardListIndex.values()[TABLEAU_PILE_1.ordinal() + tableauPile];
    }
}
