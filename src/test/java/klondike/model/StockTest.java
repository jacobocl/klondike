package klondike.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StockTest {
    
    CardList stock;
    
    List<Card> cards;

    @Before
    public void before() {
        stock = new Stock();
        cards = new ArrayList<Card>();
        cards.add(new Card(Suit.DIAMOND, Number.FIVE));
        cards.add(new Card(Suit.HEART, Number.KING));
    }

    @Test
    public void testAddCards() {
        int initialSize = stock.size();
        stock.addCards(cards);
        
        assertEquals(initialSize + cards.size(), stock.size());
        List<Card> lastStockCards = stock.getCards(cards.size());
        assertTrue(cards.containsAll(lastStockCards));
    }

}
