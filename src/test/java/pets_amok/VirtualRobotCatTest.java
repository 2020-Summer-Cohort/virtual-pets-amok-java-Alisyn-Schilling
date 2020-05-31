package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualRobotCatTest {

    @Test
    public void canCreateRobotCat() {
        VirtualRobotPet underTest = new VirtualRobotCat("Runtime", "Robot Cat", 50, 53);
        assertEquals("Runtime", underTest.getName());
        assertEquals(50, underTest.getOilLevels());
    }

    @Test
    public void canOilRobotCat() {
        VirtualRobotPet underTest = new VirtualRobotCat("Runtime", "Robot Cat", 50, 53);
        underTest.addOil(10);
        assertEquals(60, underTest.getOilLevels());
    }

    @Test
    public void canTickRobotCat() {
        VirtualRobotPet underTest = new VirtualRobotCat("Runtime", "Robot Cat", 50, 53);
        underTest.tick();
        assertEquals(40, underTest.getOilLevels());
    }

    @Test
    public void canPlayWithRobotCat() {
        VirtualPet underTest = new VirtualRobotCat("Taz", "Robot Cat", 50, 53);
        underTest.play(10);
        assertEquals(43, underTest.getBoredom());
    }

    @Test
    public void canCalculateCatHealth() {
        VirtualPet underTest = new VirtualRobotCat("Taz", "cat", 51, 52);
        underTest.calculateHealth();
        assertEquals(49, underTest.getHealth(), .01);
    }
}
