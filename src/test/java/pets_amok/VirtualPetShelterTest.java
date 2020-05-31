package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetShelterTest {
    @Test
    public void canCreateShelter(){
        VirtualPetShelter underTest = new VirtualPetShelter();
    }
    @Test
    public void canAddPetToShelter(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualCat("Taz", "Cat", 51, 52, 53);
        underTest.add(underTestPet);
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals("Taz", pet.getName());
    }
    @Test
    public void canFeedAllOrganicPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualCat("Taz", "Cat", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotCat("Runtime", "Robot Cat", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.feedAllPets(10);
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals(41, ((VirtualOrganicPet)pet).getHunger());
    }
    @Test
    public void canWaterAllOrganicPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualCat("Taz", "Cat", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotCat("Runtime", "Robot Cat", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.waterAllPets(10);
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals(42, ((VirtualOrganicPet)pet).getThirst());
    }
    @Test
    public void canOilAllRobotPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestRobotDog = new VirtualRobotDog("Taz", "RobotDog", 25, 53);
        VirtualPet underTestRobotCat = new VirtualRobotCat("Runtime", "Robot Cat", 25, 53);
        underTest.add(underTestRobotDog);
        underTest.add(underTestRobotCat);
        underTest.addOilToAllPets(10);
        VirtualPet pet1 = underTest.getPetFromShelter("Taz");
        VirtualPet pet2 = underTest.getPetFromShelter("Runtime");
        assertEquals(35, ((VirtualRobotPet) pet1).getOilLevels());
        assertEquals(35, ((VirtualRobotPet) pet2).getOilLevels());

    }
    @Test
    public void canTickAllPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualCat("Taz", "Cat", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotCat("Runtime", "Robot Cat", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.tickAllPets();
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        VirtualPet pet2 = underTest.getPetFromShelter("Runtime");
        assertEquals(56, ((VirtualOrganicPet)pet).getHunger());
        assertEquals(15, ((VirtualRobotPet)pet2).getOilLevels());
    }
    @Test
    public void canWalkAllDogs(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog",51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotDog("Runtime", "Robot Dog", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.tickAllPets();
        underTest.walkAllDogs();
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        VirtualPet pet2 = underTest.getPetFromShelter("Runtime");
        assertEquals(20, ((Walking)pet).getWalkHappiness());
        assertEquals(20, ((Walking)pet2).getWalkHappiness());
    }
    @Test
    public void canPlayWithAPet() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotDog("Runtime", "Robot Dog", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.playWithPet("Taz", 10);
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals(43, pet.getBoredom());
    }
    @Test
    public void canCleanDogCages(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog", 51, 52, 53);
        underTest.add(underTestPet);
        underTest.cleanDogCages(10);
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals(10, ((VirtualDog) pet).getCageDirtLevel());
    }
    @Test
    public void canRemovePetFromShelter(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog",51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotDog("Runtime","RobotDog", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.remove("Taz");
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertNull(pet);
    }
    @Test
    public void canCheckIfPetIsInShelter(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotDog("Runtime", "RobotDog", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        assertTrue(underTest.isInShelter("Taz"));
    }
    @Test
    public void canCalculateHealthAllPets(){
        VirtualPetShelter underTest = new VirtualPetShelter();
        VirtualPet underTestPet = new VirtualDog("Taz", "Dog", 51, 52, 53);
        VirtualPet underTestRobotPet = new VirtualRobotDog("Runtime", "RobotDog", 25, 53);
        underTest.add(underTestPet);
        underTest.add(underTestRobotPet);
        underTest.calculateAllPetHappiness();
        VirtualPet pet = underTest.getPetFromShelter("Taz");
        assertEquals(51, pet.getHealth());
    }
}
