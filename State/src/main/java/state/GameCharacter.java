package state;

public class GameCharacter {

    private String name;
    private int experience;
    private int health;

    private State state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState();
    }

    public void setState(State newState) {
        this.state = newState;
    }

    public String getLevel() {
        return state.getLevelName();
    }

    public void addExperience(int xp) {
        this.experience += xp;
    }

    public int getExperience() {
        return this.experience;
    }

    public void addHealth(int hp) {
        this.health += hp;
        if (health > 100) health = 100;
    }

    public int getHealth() {
        return this.health;
    }

    public void train() {
        state.train(this);
    }

    public void meditate() {
        state.meditate(this);
    }

    public void fight() {
        state.fight(this);
    }

    public void displayStatus() {
        System.out.println("---------------------");
        System.out.println("Name: " + name);
        System.out.println("Level: " + getLevel());
        System.out.println("HP: " + health);
        System.out.println("XP: " + experience);
        System.out.println("---------------------");
    }
}