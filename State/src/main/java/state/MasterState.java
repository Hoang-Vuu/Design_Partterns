package state;

public class MasterState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You are already a Master. No further training available.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Masters do not need meditation.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Masters do not fight petty battles.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}