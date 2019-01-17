import java.util.Random;


public class Horse implements Comparable<Horse>{
    private String name;
    private int speed;
    private int fatigue;
    private int fatigueIncrease;
    private int fatigueDecrease;
    private boolean onRace;
    private double actualSpeed;
    private int numRaces;

    public Horse(String name, int speed, int fatigueIncrease, int fatigueDecrease) {
        this.name = name;
        this.speed = speed;
        this.fatigueIncrease = fatigueIncrease;
        this.fatigueDecrease = fatigueDecrease;
        this.fatigue = 0;
        this.onRace = false;
        this.actualSpeed = 0.0;
        this.numRaces = 0;
    }

    public void goRace(){
        this.onRace = true;
        this.fatigue += this.fatigueIncrease;
        if(this.fatigue > 100) {
            this.fatigue = 100;
        }
        this.numRaces++;
        
    }

    public int getNumRaces() {
        return this.numRaces;
    }

    public void goRest() {
        this.onRace = false;
        this.fatigue -= this.fatigueDecrease;
        if(this.fatigue < 0) {
            this.fatigue = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getActualSpeed() {
        return this.actualSpeed;
    }

    public void setActualSpeed() {
        this.actualSpeed += 5;
    }
    
    public int getFatigue() {
        return this.fatigue;
    }

    public boolean getOnRace(){
        return this.onRace;
    }

    public double countSpeed() {
        Random randomizer = new Random();       
        double modifier = ((randomizer.nextInt(100)) * ((double)(100 - this.fatigue)/100)); 
        this.actualSpeed = (this.speed + modifier);
        return actualSpeed;
    }

    @Override
    public int compareTo(Horse compared) {
        return (int)this.actualSpeed - (int)compared.actualSpeed;
    }

}
