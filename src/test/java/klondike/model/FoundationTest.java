package klondike.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FoundationTest {

    CardList foundation;

    List<Card> cardsFlippedUp;

    @Before
    public void before() {
        foundation = new Foundation();
        cardsFlippedUp = new ArrayList<Card>();

        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Number.values().length; j++) {
                Card card = new Card(Suit.values()[i], Number.values()[j]);
                card.setFlippedUp(true);
                cardsFlippedUp.add(card);
            }
        }
        Collections.shuffle(cardsFlippedUp);
    }

    @Test
    public void testSize() {
        assertEquals(0, foundation.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(foundation.isEmpty());
    }

    @Test
    public void testAddCards() {
        foundation.addCards(cardsFlippedUp);
        List<Card> wasteCards = foundation.getCards(cardsFlippedUp.size());
        assertTrue(wasteCards.equals(cardsFlippedUp));
    }

    @Test
    public void testGetCard() {
        foundation.addCards(cardsFlippedUp);
        assertNotNull(foundation.getCard());
    }

    @Test
    public void testRemove() {
        foundation.addCards(cardsFlippedUp);
        int initialSize = foundation.size();
        int cardsToRemove = 5;
        foundation.remove(cardsToRemove);
        assertEquals(initialSize - cardsToRemove, foundation.size());
    }

    @Test
    public void testSetVisibleCards() {
        int visibleCards = 5;
        foundation.setVisibleCards(visibleCards);
        assertEquals(visibleCards, foundation.getVisibleCards());
    }

    @Test
    public void testInvisibleCards() {
        foundation.addCards(cardsFlippedUp);
        int visibleCards = 5;
        assertEquals(cardsFlippedUp.size() - 1, foundation.invisibleCards());
        foundation.setVisibleCards(visibleCards);
        assertEquals(cardsFlippedUp.size() - 5, foundation.invisibleCards());
    }

}
