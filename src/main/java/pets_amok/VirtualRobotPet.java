package pets_amok;

public abstract class VirtualRobotPet extends VirtualPet {
    protected int oilLevels;

    public VirtualRobotPet(String name,String description, int oilLevels, int boredom) {
        super(name, description, boredom);
        this.oilLevels = oilLevels;
    }

    public int getOilLevels() {
        return oilLevels;
    }

    @Override
    public void calculateHealth() {
        health =(double)((oilLevels + (100 - boredom))/2);
    }

    @Override
    public void tick() {
        super.tick();
        oilLevels -= 10;
        if (oilLevels < 0){
            oilLevels = 0;
        }
    }

    public void addOil(int oilToAdd) {
        oilLevels += oilToAdd;
        if (oilLevels > 100){
            oilLevels = 100;
        }
    }
}
