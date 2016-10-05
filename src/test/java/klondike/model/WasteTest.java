package klondike.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WasteTest {

    CardList waste;

    List<Card> cards;

    @Before
    public void before() {
        waste = new Waste();
        cards = new ArrayList<Card>();
        Card fiveDiamond = new Card(Suit.DIAMOND, Number.FIVE);
        fiveDiamond.setFlippedUp(true);
        Card kingHeart = new Card(Suit.HEART, Number.KING);
        kingHeart.setFlippedUp(true);
        cards.add(fiveDiamond);
        cards.add(kingHeart);
    }

    @Test
    public void testAddCards() {
        int initialWasteSize = waste.size();
        waste.addCards(cards);
        assertEquals(initialWasteSize + cards.size(), waste.size());
        assertEquals(initialWasteSize + cards.size(), waste.getVisibleCards());

        assertTrue(cards.equals(waste.getCards(cards.size())));
    }

    @Test
    public void testRemove() {
        waste.addCards(cards);
        int initialWasteSize = waste.size();
        waste.remove(2);

        assertEquals(initialWasteSize - 2, waste.size());
        assertEquals(1, waste.getVisibleCards());
    }

}
