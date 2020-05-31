package pets_amok;

public class VirtualRobotDog extends VirtualRobotPet implements Walking {
    private int walkHappiness;

    public VirtualRobotDog(String name, String description, int oilLevel, int boredom) {
        super(name, description, oilLevel, boredom);
        this.walkHappiness = 15;
    }

    @Override
    public int getWalkHappiness() {
        return walkHappiness;
    }

    @Override
    public void walk() {
        oilLevels -= 2;
        walkHappiness = 20;
    }

    @Override
    public void tick() {
        super.tick();
        walkHappiness -= 1;
    }

    @Override
    public void calculateHealth() {
        super.calculateHealth();
        health += walkHappiness - 10;
    }

}
