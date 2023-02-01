package guess;

import java.io.Console;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        do {
            guessNumber();
        } while(playAgain());
        
        
    }

    public static void guessNumber() {
        int number = new Random().nextInt(20) + 1; // range is 0-19 so need to adjust
        int guess = 0;
        int tries = 5;
        Console cons = System.console();
        boolean hasWon = false;

        System.out.printf("To guess: %d\n", number);
        System.out.printf("Guess a number between 1 and 20.\n");
        while(tries > 0 && !hasWon) {
            guess = Integer.parseInt(cons.readLine("What is your guess? (%d tries)\n", tries));
            if(number != guess) {
                tries--;
                if(number > guess) {
                    System.out.printf("Higher!\n");
                } else {
                    System.out.printf("Lower!\n");
                }
            } else {
                System.out.printf("You win!\n");
                hasWon = true;
            }
        }

        if(!hasWon) {
            System.out.printf("You lose. the number is %d.\n", number);
        }

    }

    public static boolean playAgain() {
        Console cons = System.console();
        String input = cons.readLine("Do you want to play again? (Y/N)\n");

        boolean toPlay = false;

        switch(input.toLowerCase()) {
            case "y" -> toPlay = true;
            case "n" -> toPlay = false;
            default -> {
                System.out.printf("Invalid input. ");
                toPlay = playAgain();
            }
        }

        return toPlay;
        
    }
}