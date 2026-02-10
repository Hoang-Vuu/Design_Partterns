package state;

public class NoviceState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train and gain +10 XP.");
        character.addExperience(10);

        if (character.getExperience() >= 50) {
            System.out.println("You advanced to INTERMEDIATE level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novices cannot meditate.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novices cannot fight.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}