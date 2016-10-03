package klondike.model;

public class Foundation extends CardList {

    public Foundation() {
        super();
    }

    @Override
    public void add(Card card) {
        assert card != null;
        assert card.isFlippedUp();
        getCards().add(card);
    }

    @Override
    public Card get() {
        assert getCards().size() >= 1;
        return getCards().get(getCards().size() - 1);
    }

    @Override
    public Card remove() {
        assert getCards().size() >= 1;
        Card card = getCards().remove(getCards().size());
        getCards().get(getCards().size()).setFlippedUp(true);
        return card;
    }

}
