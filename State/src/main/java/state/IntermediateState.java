package state;

public class IntermediateState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train and gain +15 XP.");
        character.addExperience(15);

        if (character.getExperience() >= 120) {
            System.out.println("You advanced to EXPERT level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditate and gain +10 HP.");
        character.addHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediate level cannot fight yet.");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}
