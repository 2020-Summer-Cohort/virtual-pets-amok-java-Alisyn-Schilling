package pets_amok;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VirtualPet pet1 = new VirtualDog("Sadie", "A energetic black lav",
                54, 46, 52);
        VirtualPet pet2 = new VirtualCat("Taz", "An old social tabby cat",
                53, 47, 58);
        VirtualPet pet3 = new VirtualRobotCat("Carter", "A cuddly calico robot cat",
                47, 56);
        VirtualPet pet4 = new VirtualRobotDog("Sif", "A giant robot wolf",
                58, 42);
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.add(pet1);
        shelter.add(pet2);
        shelter.add(pet3);
        shelter.add(pet4);

        System.out.println("Welcome to your Virtual Pet Shelter!\n");

        while (true) {
            System.out.println("This is the status of your pets:\n");
            getPetsStatus(shelter);
            System.out.println("What would you like to do next?\n");
            int input = shelterInteraction(scanner, shelter);
            if (input == 0) {
                break;
            }
            shelter.tickAllPets();
        }
    }

    public static int shelterInteraction(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("1. Feed the pets\n" +
                "2. Water the pets\n" +
                "3. Play with a pet\n" +
                "4. Oil the Robot Pets\n" +
                "5. Clean Dog Cages\n" +
                "6. Walk the Dogs\n" +
                "7. Adopt a pet\n" +
                "8. Admit a pet\n" +
                "0. Quit");
        int input = scanner.nextInt();
        input = shelterHelp(scanner, input);
        if (input == 1) {
            shelter.feedAllPets(43);
            System.out.println("You feed the pets!");
        } else if (input == 2) {
            shelter.waterAllPets(47);
            System.out.println("You water the pets!");
        } else if (input == 3) {
            scanner.nextLine();
            playWithPet(scanner, shelter);
        } else if (input == 4) {
            shelter.addOilToAllPets(50);
            System.out.println("You oiled the robotic pets");
        } else if (input == 5) {
            shelter.cleanDogCages(50);
            System.out.println("You cleaned the Cages!");
        } else if (input == 6) {
            shelter.walkAllDogs();
            System.out.println("You walked all the dogs");
        } else if (input == 7) {
            scanner.nextLine();
            adoptPet(scanner, shelter);
        } else if (input == 8) {
            scanner.nextLine();
            admitPet(scanner, shelter);
        }
        return input;

    }

    public static void playWithPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to play with a pet. Please choose one:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println(pet.getName() + ": " + pet.getDescription());
        }
        System.out.println("\nWhich pet would you like to play with?");
        String pet = scanner.nextLine();
        pet = petHelp(scanner, shelter, pet);
        shelter.playWithPet(pet, 53);
    }

    public static void adoptPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to adopt a pet. Please choose one:\n");
        for (VirtualPet pet : shelter.getAllPets()) {
            System.out.println(pet.getName() + ": " + pet.getDescription());
        }
        System.out.println("\nWhich pet would you like to adopt?");
        String pet = scanner.nextLine();
        pet = petHelp(scanner, shelter, pet);
        shelter.remove(pet);
    }

    public static void admitPet(Scanner scanner, VirtualPetShelter shelter) {
        System.out.println("OK, so you'd like to admit a pet.\n");
        System.out.println("What type of pet is it? Cat, Dog, Robot Cat, Robot Dog");
        String petType = scanner.nextLine();
        petType = petTypeHelp(scanner, petType);
        System.out.println("What is its name?");
        String name = scanner.nextLine();
        System.out.println("Please give a description of the pet.");
        String description = scanner.nextLine();
        System.out.println("On a scale of 1 - 100, how bored is the pet?");
        int boredom = scanner.nextInt();
        VirtualPet virtualPet;
        if (petType.equalsIgnoreCase("Dog") || petType.equalsIgnoreCase("Cat")) {
            System.out.println("On a scale of 1 - 100, how hungry is the pet?");
            scanner.nextLine();
            int hunger = scanner.nextInt();
            System.out.println("On a scale of 1 - 100, how thirsty is the pet?");
            int thirst = scanner.nextInt();
            if (petType.equalsIgnoreCase("Dog")) {
                virtualPet = new VirtualDog(name, description, hunger, thirst, boredom);
                shelter.add(virtualPet);
            }
            if (petType.equalsIgnoreCase("Cat")) {
                virtualPet = new VirtualCat(name, description, hunger, thirst, boredom);
                shelter.add(virtualPet);
            }
        } else if (petType.equalsIgnoreCase("Robot Dog") || petType.equalsIgnoreCase("Robot Cat")) {
            System.out.println("On a scale of 1-100, what is the oil level of the Robot Pet?");
            int oilLevel = scanner.nextInt();
            if (petType.equalsIgnoreCase("Robot Dog")) {
                virtualPet = new VirtualRobotDog(name, description, oilLevel, boredom);
                shelter.add(virtualPet);
            }
            if (petType.equalsIgnoreCase("Robot Cat")) {
                virtualPet = new VirtualRobotCat(name, description, oilLevel, boredom);
                shelter.add(virtualPet);
            }
        }
        System.out.println(name + " has been added to the shelter.");
    }

    public static int shelterHelp(Scanner scanner, int input) {
        while ((input > 8) || (input < 0)) {
            System.out.println("Please enter a number between 0 and 8:");
            input = scanner.nextInt();
        }
        return input;
    }

    public static String petHelp(Scanner scanner, VirtualPetShelter shelter, String pet) {
        boolean petInShelter = shelter.isInShelter(pet);
        while (!petInShelter) {
            System.out.println("Please select a pet from the list.");
            pet = scanner.nextLine();
            petInShelter = shelter.isInShelter(pet);
        }
        return pet;
    }

    public static String petTypeHelp(Scanner scanner, String petType) {
        while (!petType.equalsIgnoreCase("Dog") &&
                !petType.equalsIgnoreCase("Cat") &&
                !petType.equalsIgnoreCase("Robot Dog") &&
                !petType.equalsIgnoreCase("Robot Cat")) {
            System.out.println("Please select a pet type from the list.");
            petType = scanner.nextLine();
        }
        return petType;
    }

    public static void getPetsStatus(VirtualPetShelter shelter) {
        shelter.calculateAllPetHappiness();
        getCatStatus(shelter);
        getDogStatus(shelter);
        getRobotPetStatus(shelter);
        System.out.println();
    }

    public static void getCatStatus(VirtualPetShelter shelter) {
        System.out.println("Cat Status");
        System.out.println("Name    |Health  |Hunger  |Thirst  |Boredom");
        System.out.println("--------|--------|--------|--------|-------");
        for (VirtualPet virtualPet : shelter.getAllPets()) {
            if (virtualPet instanceof VirtualCat) {
                StringBuilder petName = new StringBuilder(virtualPet.getName());
                while (petName.length() < 8) {
                    petName.append(" ");
                }
                StringBuilder petHealth = new StringBuilder();
                petHealth.append(virtualPet.getHealth());
                while (petHealth.length() < 8) {
                    petHealth.append(" ");
                }
                StringBuilder petHunger = new StringBuilder();
                petHunger.append(((VirtualCat) virtualPet).getHunger());
                while (petHunger.length() < 8) {
                    petHunger.append(" ");
                }
                StringBuilder petThirst = new StringBuilder();
                petThirst.append(((VirtualCat) virtualPet).getThirst());
                while (petThirst.length() < 8) {
                    petThirst.append(" ");
                }
                StringBuilder petBoredom = new StringBuilder();
                petBoredom.append(virtualPet.getBoredom());
                while (petBoredom.length() < 8) {
                    petBoredom.append(" ");
                }
                System.out.println(petName + "|"
                        + petHealth + "|"
                        + petHunger + "|"
                        + petThirst + "|"
                        + petBoredom);
            }
        }
    }

    public static void getDogStatus(VirtualPetShelter shelter) {
        System.out.println("Dog Status");
        System.out.println("Name    |Health  |Hunger  |Thirst  |Boredom |Cage Dirt");
        System.out.println("--------|--------|--------|--------|--------|--------");
        for (VirtualPet virtualPet : shelter.getAllPets()) {
            if (virtualPet instanceof VirtualDog) {
                StringBuilder petName = new StringBuilder(virtualPet.getName());
                while (petName.length() < 8) {
                    petName.append(" ");
                }
                StringBuilder petHealth = new StringBuilder();
                petHealth.append(virtualPet.getHealth());
                while (petHealth.length() < 8) {
                    petHealth.append(" ");
                }
                StringBuilder petHunger = new StringBuilder();
                petHunger.append(((VirtualDog) virtualPet).getHunger());
                while (petHunger.length() < 8) {
                    petHunger.append(" ");
                }
                StringBuilder petThirst = new StringBuilder();
                petThirst.append(((VirtualDog) virtualPet).getThirst());
                while (petThirst.length() < 8) {
                    petThirst.append(" ");
                }
                StringBuilder petBoredom = new StringBuilder();
                petBoredom.append(virtualPet.getBoredom());
                while (petBoredom.length() < 8) {
                    petBoredom.append(" ");
                }
                StringBuilder petCageDirt = new StringBuilder();
                petCageDirt.append(((VirtualDog) virtualPet).getCageDirtLevel());
                while (petCageDirt.length() < 8) {
                    petCageDirt.append(" ");
                }
                System.out.println(petName + "|"
                        + petHealth + "|"
                        + petHunger + "|"
                        + petThirst + "|"
                        + petBoredom + "|"
                        + petCageDirt);
            }
        }
    }

    public static void getRobotPetStatus(VirtualPetShelter shelter) {
        System.out.println("Robot Pet Status");
        System.out.println("Name    |Type    |Health  |Oil Level|Boredom");
        System.out.println("--------|--------|--------|---------|--------");
        for (VirtualPet virtualPet : shelter.getAllPets()) {
            String robotType = "Cat     ";
            if (virtualPet instanceof VirtualRobotDog) {
                robotType = "Dog     ";
            }
            if (virtualPet instanceof VirtualRobotPet) {
                StringBuilder petName = new StringBuilder(virtualPet.getName());
                while (petName.length() < 8) {
                    petName.append(" ");
                }
                StringBuilder petHealth = new StringBuilder();
                petHealth.append(virtualPet.getHealth());
                while (petHealth.length() < 8) {
                    petHealth.append(" ");
                }
                StringBuilder petOilLevel = new StringBuilder();
                petOilLevel.append(((VirtualRobotPet) virtualPet).getOilLevels());
                while (petOilLevel.length() < 9) {
                    petOilLevel.append(" ");
                }
                StringBuilder petBoredom = new StringBuilder();
                petBoredom.append(virtualPet.getBoredom());
                while (petBoredom.length() < 8) {
                    petBoredom.append(" ");
                }
                System.out.println(petName + "|"
                        + robotType + "|"
                        + petHealth + "|"
                        + petOilLevel + "|"
                        + petBoredom);
            }
        }
    }
}

