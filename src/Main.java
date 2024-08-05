import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        boolean playAgain = true;
        while (playAgain) {
            int point = 0;
            boolean keepRolling = true;

            int roll = rollDice(random);
            System.out.println("You rolled: " + roll);

            if (roll == 7 || roll == 11) {
                System.out.println("You win!");
            } else if (roll == 2 || roll == 3 || roll == 12) {
                System.out.println("Craps!");
            } else {
                point = roll;
                System.out.println("Your point: " + point);

                while (keepRolling) {
                    roll = rollDice(random);
                    System.out.println("You rolled: " + roll);

                    if (roll == point) {
                        System.out.println("You win!");
                        keepRolling = false;
                    } else if (roll == 7) {
                        System.out.println("You rolled a 7 womp womp");
                        keepRolling = false;
                    }
                }
            }

            System.out.print("play again?: ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }


        scanner.close();
    }

    private static int rollDice(Random random) {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        return die1 + die2;
    }
}
