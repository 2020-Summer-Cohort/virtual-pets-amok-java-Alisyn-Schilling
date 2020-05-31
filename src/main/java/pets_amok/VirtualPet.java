package pets_amok;

public abstract class VirtualPet {
    private final String name;
    private final String description;
    protected double health;
    protected int boredom;


    public VirtualPet(String name, String description, int boredom) {
        this.name = name;
        this.description = description;
        this.boredom = boredom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return (int) health;
    }
    public int getBoredom(){
        return boredom;
    }
    public abstract void calculateHealth();

    public void tick(){
        boredom += 3;
        if (boredom> 100) {
            boredom = 100;
        }
    }

    public void play(int play){
        boredom -= play;
        if (boredom < 0){
            boredom = 0;
        }
    }
}
