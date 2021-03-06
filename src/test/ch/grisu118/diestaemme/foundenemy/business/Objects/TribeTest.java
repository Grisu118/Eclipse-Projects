package ch.grisu118.diestaemme.foundenemy.business.Objects;

import static org.junit.Assert.*;

import org.junit.Test;

public class TribeTest {

    @Test
    public void testTribe() {
        try {
            new Tribe(null, "shortName", 23);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal Tribe name", e.getMessage());
        }
        try {
            new Tribe("", "shortName", 23);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal Tribe name", e.getMessage());
        }
        try {
            new Tribe("name", null, 23);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal Tribe short name", e.getMessage());
        }
        try {
            new Tribe("name", "", 23);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal Tribe short name", e.getMessage());
        }
        try {
            new Tribe("name", "shortName", -2);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal memberCount", e.getMessage());
        }
        try {
            new Tribe("name", "shortName", 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertEquals("illegal memberCount", e.getMessage());
        }

        Tribe t1 = new Tribe("name", "shortName", 1);
        assertEquals(t1.getName(), "shortName");
        assertEquals(t1.getTribeName(), "name");
        assertEquals(t1.getMemberCount(), 1);
        Tribe t2 = new Tribe("567987resfdgkztu", "dsgh", 150);
        assertEquals(t2.getName(), "dsgh");
        assertEquals(t2.getTribeName(), "567987resfdgkztu");
        assertEquals(t2.getMemberCount(), 150);
    }

    @Test
    public void testAddPlayer() {
        Tribe t1 = new Tribe("Name", "Kürzel", 4);
        t1.addPlayer(new Player("xy1", 21, 20453));
        t1.addPlayer(new Player("xy2", 1, 5555));
        t1.addPlayer(new Player("xy3", 865, 54323467));
        t1.addPlayer(new Player("xy4", 34, 9876543));
        
        try {
            t1.addPlayer(new Player("xy5", 21, 20453));
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
        
        assertTrue(t1.getPlayer(0).equals(new Player("xy1", 21, 20453)));
        assertTrue(t1.getPlayer(1).equals(new Player("xy2", 1, 5555)));
        assertTrue(t1.getPlayer(2).equals(new Player("xy3", 865, 54323467)));
        assertTrue(t1.getPlayer(3).equals(new Player("xy4", 34, 9876543)));

    }
    
    @Test
    public void testEquals() {
        Tribe t1 = new Tribe("Ich bin da", "IbD", 23);
        assertTrue(t1.equals(new Tribe("Ich bin da", "IbD", 23)));
        assertTrue(!t1.equals(new Tribe("Ich bn da", "IbD", 23)));
        
        assertTrue(!t1.equals(new Tribe("Ich bin da", "gf", 23)));
        assertTrue(!t1.equals(new Tribe("Ich bin da", "IbD", 22)));
        
        t1 = new Tribe("dsgda", "ddf", 25);
        assertEquals(t1, new Tribe("dsgda", "ddf", 25));
    }

}
