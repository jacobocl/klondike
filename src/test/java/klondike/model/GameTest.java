package klondike.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Game game;

    @Before
    public void before() {
        game = new Game();
    }

    @Test
    public void testSetGameState() {
        assertEquals(GameState.INITIAL, game.getGameState());

        game.setGameState(GameState.IN_GAME);
        assertEquals(GameState.IN_GAME, game.getGameState());

        game.setGameState(GameState.FINAL);
        assertEquals(GameState.FINAL, game.getGameState());
    }

    @Test
    public void testGetCard() {
        assertNotNull(game.getCard(CardListIndex.STOCK));
    }

    @Test
    public void testGetCards() {
        assertEquals(4, game.getCards(CardListIndex.STOCK, 4).size());
    }

    @Test
    public void testRemoveCards() {
        int initialSize = game.size(CardListIndex.STOCK);
        game.removeCards(CardListIndex.STOCK, 5);
        assertEquals(initialSize - 5, game.size(CardListIndex.STOCK));
    }

    @Test
    public void testAddCard() {
        Card card = game.getCard(CardListIndex.STOCK);
        card.setFlippedUp(true);
        game.addCard(CardListIndex.WASTE, card);
        assertEquals(1, game.size(CardListIndex.WASTE));
        assertEquals(52, game.size(CardListIndex.STOCK));
        assertEquals(0, game.size(CardListIndex.FOUNDATION_1));
        assertEquals(0, game.size(CardListIndex.TABLEAU_PILE_7));
    }

    @Test
    public void testAddCards() {
        List<Card> cards = game.getCards(CardListIndex.STOCK, 5);
        game.addCards(CardListIndex.TABLEAU_PILE_3, cards);
        assertEquals(0, game.size(CardListIndex.WASTE));
        assertEquals(52, game.size(CardListIndex.STOCK));
        assertEquals(0, game.size(CardListIndex.FOUNDATION_1));
        assertEquals(5, game.size(CardListIndex.TABLEAU_PILE_3));
        assertEquals(0, game.size(CardListIndex.TABLEAU_PILE_7));
    }

}
