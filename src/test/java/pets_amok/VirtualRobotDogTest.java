package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualRobotDogTest {
    @Test
    public void canCreateRobotDog(){
        VirtualRobotPet underTest = new VirtualRobotDog("Joey", "Robot Dog", 50, 53);
        assertEquals("Joey", underTest.getName());
        assertEquals(50, underTest.getOilLevels());
    }
    @Test
    public void canOilRobotDog(){
        VirtualRobotPet underTest = new VirtualRobotDog("Joey", "Robot Dog", 50, 53);
        underTest.addOil(10);
        assertEquals(60, underTest.getOilLevels());
    }
    @Test
    public void canTickRobotDog(){
        VirtualRobotPet underTest = new VirtualRobotDog("Joey", "Robot Dog", 50, 53);
        underTest.tick();
        assertEquals(40, underTest.getOilLevels());
    }
    @Test
    public void canWalkRobotDog(){
        VirtualRobotDog underTest = new VirtualRobotDog("Sadie", "Robot Dog", 50, 53);
        underTest.tick();
        ((Walking)underTest).walk();
        assertEquals(20, underTest.getWalkHappiness());
    }
    @Test
    public void canPlayWithRobotDog(){
        VirtualPet underTest = new VirtualRobotDog("Taz", "Robot Dog", 50,53);
        underTest.play(10);
        assertEquals(43, underTest.getBoredom());
    }
    @Test
    public void canCalculateCatHealth(){
        VirtualPet underTest = new VirtualRobotDog("Taz", "dog", 51,52);
        underTest.calculateHealth();
        assertEquals(54, underTest.getHealth());
    }
}
