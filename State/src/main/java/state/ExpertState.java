package state;

public class ExpertState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Expert training gives +20 XP.");
        character.addExperience(20);

        if (character.getExperience() >= 250) {
            System.out.println("You advanced to MASTER level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Expert meditation restores +15 HP.");
        character.addHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You fight fiercely: -20 HP, +30 XP.");

        character.addHealth(-20);
        character.addExperience(30);

        if (character.getHealth() <= 0) {
            System.out.println("💀 You died in battle.");
            System.exit(0);
        }

        if (character.getExperience() >= 250) {
            System.out.println("You advanced to MASTER level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}