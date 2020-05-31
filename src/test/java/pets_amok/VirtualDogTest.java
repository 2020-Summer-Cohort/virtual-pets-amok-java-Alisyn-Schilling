package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualDogTest {
    @Test
    public void canCreateDog() {
        VirtualOrganicPet underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        assertEquals("Sadie", underTest.getName());
        assertEquals(51, underTest.getHunger());
        assertEquals(52, underTest.getThirst());
    }

    @Test
    public void canCalculateDogHealth() {
        VirtualPet underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.calculateHealth();
        assertEquals(51, underTest.getHealth());
    }

    @Test
    public void canFeedDog() {
        VirtualOrganicPet underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.feed(10);
        assertEquals(41, underTest.getHunger());
    }

    @Test
    public void canWaterDog() {
        VirtualOrganicPet underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.water(10);
        assertEquals(42, underTest.getThirst());
    }

    @Test
    public void canTickDog() {
        VirtualOrganicPet underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.tick();
        assertEquals(56, underTest.getHunger());
        assertEquals(60, underTest.getThirst());
    }

    @Test
    public void canWalkDog() {
        VirtualDog underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.tick();
        ((Walking) underTest).walk();
        assertEquals(20, underTest.getWalkHappiness());
        assertEquals(58, underTest.getHunger());
        assertEquals(63, underTest.getThirst());
    }

    @Test
    public void canPlayWithDog() {
        VirtualPet underTest = new VirtualDog("Taz", "dog", 51, 52, 53);
        underTest.play(10);
        assertEquals(43, underTest.getBoredom());
    }

    @Test
    public void canCleanCage() {
        VirtualDog underTest = new VirtualDog("Sadie", "dog", 51, 52, 53);
        underTest.cleanCage(10);
        assertEquals(10, underTest.getCageDirtLevel());
    }

}
