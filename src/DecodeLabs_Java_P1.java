
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("        Number Guessing Game        ");
        System.out.println("=============================================");

        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        while(playAgain) {
            int target = random.nextInt(100)+1;
            int attempts = 0;
            boolean guessing = false;
            int maxAttempts = 7;

            while(!guessing && attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                try {
                    int guess = sc.nextInt();
                    attempts ++;

                    if(guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }

                    if(target == guess) {
                        totalScore += (maxAttempts - attempts + 1);
                        guessing = true;
                        System.out.println("\nCongratulations!");
                        System.out.println("You guessed the correct number!");
                        System.out.println("Attempts: "+attempts);
                    }

                    else if(guess < target) {
                        System.out.println("Too Low!");
                    }

                    else {
                        System.out.println("Too High!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input. Please enter right input in form of number");
                    sc.next();
                }
            }

            if(!guessing) {
                System.out.println("Game Over");
                System.out.println("The Correct number was: "+target);
            }

            System.out.println("Total Score : "+totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");

            String choice = sc.next();

            if(!choice.equalsIgnoreCase("Y")) {
                playAgain = false;
            }

            round ++;
        }

        System.out.println("\n======================================");
        System.out.println("        GAME FINISHED      ");
        System.out.println("======================================");
        System.out.println("Rounds Played : " + (round - 1));
        System.out.println("Final Score   : " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}

