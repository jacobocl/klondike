package klondike.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

    private Card threeDiamond;

    private Card aceHeart;

    private Card kingClub;

    private Card twoHeart;

    @Before
    public void before() {
        threeDiamond = new Card(Suit.DIAMOND, Number.THREE);
        aceHeart = new Card(Suit.HEART, Number.ACE);
        kingClub = new Card(Suit.CLUB, Number.KING);
        twoHeart = new Card(Suit.HEART, Number.TWO);
    }

    @Test
    public void sameColorTest() {
        assertTrue(threeDiamond.sameColor(aceHeart));
        assertFalse(threeDiamond.sameColor(kingClub));
    }

    @Test
    public void sameSuitTest() {
        assertTrue(aceHeart.sameSuit(twoHeart));
        assertFalse(aceHeart.sameSuit(kingClub));
    }
    
    @Test
    public void isAceTest() {
        assertTrue(aceHeart.isAce());
        assertFalse(kingClub.isAce());
    }
    
    @Test
    public void isImmediateHigherTest() {
        assertTrue(twoHeart.isImmediateHigher(aceHeart));
        assertFalse(aceHeart.isImmediateHigher(twoHeart));
        assertFalse(threeDiamond.isImmediateHigher(kingClub));
    }
    
    @Test
    public void setFlippedUpTest() {
        assertFalse(kingClub.isFlippedUp());
        
        kingClub.setFlippedUp(true);
        assertTrue(kingClub.isFlippedUp());
    }
}
