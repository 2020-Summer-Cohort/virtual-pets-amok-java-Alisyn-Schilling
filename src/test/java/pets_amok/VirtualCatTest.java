package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualCatTest {

    @Test
    public void canCreateCat() {
        VirtualOrganicPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        assertEquals("Taz", underTest.getName());
        assertEquals(51, underTest.getHunger());
        assertEquals(52, underTest.getThirst());
    }

    @Test
    public void canCalculateCatHealth() {
        VirtualPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        underTest.calculateHealth();
        assertEquals(48, underTest.getHealth());
    }

    @Test
    public void canFeedCat() {
        VirtualOrganicPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        underTest.feed(10);
        assertEquals(41, underTest.getHunger());
    }

    @Test
    public void canWaterCat() {
        VirtualOrganicPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        underTest.water(10);
        assertEquals(42, underTest.getThirst());
    }

    @Test
    public void canTickCat() {
        VirtualOrganicPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        underTest.tick();
        assertEquals(56, underTest.getHunger());
        assertEquals(60, underTest.getThirst());
    }

    @Test
    public void canPlayWithCat() {
        VirtualPet underTest = new VirtualCat("Taz", "cat", 51, 52, 53);
        underTest.play(10);
        assertEquals(43, underTest.getBoredom());
    }


}
