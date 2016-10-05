package klondike.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TableauPileTest {

    CardList tableauPile;

    List<Card> cards;

    @Before
    public void before() {
        tableauPile = new TableauPile();

        cards = new ArrayList<Card>();
        Card flippedUpCard = new Card(Suit.HEART, Number.KING);
        flippedUpCard.setFlippedUp(true);
        cards.add(new Card(Suit.DIAMOND, Number.FIVE));
        cards.add(flippedUpCard);

        tableauPile.addCards(cards);
    }

    @Test
    public void testGetCards() {
        assertEquals(1, tableauPile.getVisibleCards());
        List<Card> cardsFromTableauPulie = tableauPile.getCards(1);
        assertEquals(cards.get(1), cardsFromTableauPulie.get(0));
    }

    @Test
    public void testRemove() {
        tableauPile.remove(1);
        assertEquals(1, tableauPile.getVisibleCards());
        tableauPile.remove(1);
        assertEquals(0, tableauPile.getVisibleCards());
    }

}
