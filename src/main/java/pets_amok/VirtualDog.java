package pets_amok;

import java.util.Random;

public class VirtualDog extends VirtualOrganicPet implements Walking {
    private int cageDirtLevel;
    private int walkHappiness;

    public VirtualDog(String name, String description, int hunger, int thirst, int boredom) {
        super(name, description, hunger, thirst, boredom);
        this.cageDirtLevel = 20;
        this.walkHappiness = 15;
    }

    public int getCageDirtLevel() {
        return cageDirtLevel;
    }

    @Override
    public int getWalkHappiness() {
        return walkHappiness;
    }

    @Override
    public void tick() {
        super.tick();
        walkHappiness -= 1;
        Random rand = new Random();
        int randomPenSoil = 0;
        if (walkHappiness != 0) {
            randomPenSoil = rand.nextInt(walkHappiness);
        }
        if ((randomPenSoil == 0 || randomPenSoil == 1)) {
            cageDirtLevel += 10;
        }
        if (cageDirtLevel > 100) {
            cageDirtLevel = 100;
        }
        if (walkHappiness < 0) {
            walkHappiness = 0;
        }
    }

    @Override
    public void walk() {
        walkHappiness = 20;
        thirst += 3;
        hunger += 2;
        if (thirst > 100) {
            thirst = 100;
        }
        if (hunger > 100) {
            hunger = 100;
        }
    }

    @Override
    public void calculateHealth() {
        double healthCalc = (thirst + hunger + cageDirtLevel + boredom);
        health = 100 - (healthCalc / 4);
        health += walkHappiness - 20;
    }

    public void cleanCage(int clean) {
        cageDirtLevel -= clean;
        if (cageDirtLevel < 0) {
            cageDirtLevel = 0;
        }
    }
}
