package ch.grisu118.diestaemme.foundenemy.business.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testPlayer() {
        try {
            new Player(null, 345, 2345);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("illegal userName", e.getMessage());
        }
        try {
            new Player("", 345, 2345);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("illegal userName", e.getMessage());
        }
        try {
            new Player("Namegültig", -3, 2345);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("illegal villageCount", e.getMessage());
        }
        try {
            new Player("Namegültig", 0, 2345);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("illegal villageCount", e.getMessage());
        }
        try {
            new Player("Namegültig", 435, -2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("illegal points", e.getMessage());
        }
        Player p1 = new Player("Namegültig", 435, 0);
        assertEquals(p1.getPoints(), 0);
        assertEquals(p1.getUserName(), "Namegültig");
        assertEquals(p1.getVillageCount(), 435);
        
        Player p2 = new Player("Namegültig", 435, 243536);
        assertEquals(p2.getPoints(), 243536);
    }

    @Test
    public void testTargets() {
        Player p1 = new Player("Namegültig", 435, 243536);
        int[] a = {0,2,4};
        p1.setTargets(a);
        assertTrue(p1.hasTargets());
        p1.setTargets(null);
        assertTrue(!p1.hasTargets());
    }

    @Test
    public void testEquals() {
        Player p1 = new Player("Namegültig", 435, 243536);
        assertEquals(new Player("Namegültig", 435, 243536), p1);
        assertTrue(!p1.equals(new Player("Namegfültig", 435, 243536)));
        assertTrue(!p1.equals(new Player("Namegültig", 433, 243536)));
        assertTrue(!p1.equals(new Player("Namegültig", 435, 7456)));
    }

}
