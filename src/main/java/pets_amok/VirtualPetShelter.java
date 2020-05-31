package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    Map<String, VirtualPet> petShelter = new HashMap<>();

    public void add(VirtualPet pet) {
        petShelter.put(pet.getName(), pet);
    }

    public VirtualPet getPetFromShelter(String name) {
        return petShelter.get(name);
    }
    public Collection<VirtualPet> getAllPets(){
        return petShelter.values();
    }

    public void feedAllPets(int food) {
        for(VirtualPet pet: petShelter.values()){
            if (pet instanceof VirtualOrganicPet){
                ((VirtualOrganicPet) pet).feed(food);
            }
        }
    }
    public void waterAllPets(int water) {
        for(VirtualPet pet: petShelter.values()){
            if (pet instanceof VirtualOrganicPet){
                ((VirtualOrganicPet) pet).water(water);
            }
        }
    }

    public void walkAllDogs() {
        for(VirtualPet pet: petShelter.values()){
            if (pet instanceof Walking){
                ((Walking) pet).walk();
            }
        }
    }

    public void tickAllPets() {
        for(VirtualPet pet: petShelter.values()){
            pet.tick();
        }
    }

    public void playWithPet(String name, int play) {
        VirtualPet pet = petShelter.get(name);
        pet.play(play);
    }

    public void cleanDogCages(int clean) {
        for (VirtualPet pet: petShelter.values()){
            if(pet instanceof VirtualDog){
                ((VirtualDog) pet).cleanCage(clean);
            }
        }
    }

    public void remove(String name) {
        petShelter.remove(name);
    }

    public boolean isInShelter(String name) {
        return petShelter.containsKey(name);
    }

    public void addOilToAllPets(int oilToAdd) {
        for (VirtualPet pet: petShelter.values()) {
            if (pet instanceof VirtualRobotPet) {
                ((VirtualRobotPet) pet).addOil(oilToAdd);
            }
        }
    }

    public void calculateAllPetHappiness() {
        for (VirtualPet pet: petShelter.values()){
            pet.calculateHealth();
        }
    }
}
