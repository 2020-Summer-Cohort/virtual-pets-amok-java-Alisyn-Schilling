package pets_amok;

public abstract class VirtualOrganicPet extends VirtualPet {
    protected int hunger;
    protected int thirst;

    public VirtualOrganicPet(String name, String description, int hunger, int thirst, int boredom) {
        super(name, description, boredom);
        this.hunger = hunger;
        this.thirst = thirst;

    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    @Override
    public void calculateHealth() {
        double healthCalc = (thirst + hunger + boredom);
        health = 100 - (healthCalc / 3);
    }

    @Override
    public void tick() {
        super.tick();
        hunger += 5;
        thirst += 8;
        if (hunger > 100) {
            hunger = 100;
        }
        if (thirst > 100) {
            thirst = 100;
        }
    }

    public void feed(int food) {
        hunger -= food;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void water(int water) {
        thirst -= water;
        if (thirst < 0) {
            thirst = 0;
        }
    }

}
