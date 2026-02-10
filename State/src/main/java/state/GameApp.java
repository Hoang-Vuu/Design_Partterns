package state;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        while (true) {
            character.displayStatus();

            System.out.println("Actions:");
            switch (character.getLevel()) {
                case "Novice":
                    System.out.println("1. Train");
                    break;
                case "Intermediate":
                    System.out.println("1. Train");
                    System.out.println("2. Meditate");
                    break;
                case "Expert":
                    System.out.println("1. Train");
                    System.out.println("2. Meditate");
                    System.out.println("3. Fight");
                    break;
                case "Master":
                    System.out.println("🎉 You reached MASTER level!");
                    System.out.println("Game over.");
                    return;
            }

            System.out.print("Choose action: ");
            int choice = scanner.nextInt();

            switch (character.getLevel()) {
                case "Novice":
                    if (choice == 1) character.train();
                    break;

                case "Intermediate":
                    if (choice == 1) character.train();
                    else if (choice == 2) character.meditate();
                    break;

                case "Expert":
                    if (choice == 1) character.train();
                    else if (choice == 2) character.meditate();
                    else if (choice == 3) character.fight();
                    break;
            }
        }
    }
}