import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int totalRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for ( int round = 1; round <=totalRounds; round++) {
            int randomNumber = random.nextInt(upperBound - lowerBound+1) + lowerBound;
            int score = 100;
                System.out.println("\nRound" + round+"- I have selected a number between " + lowerBound+ "and" + upperBound+".");
                System.out.println("you have " + maxAttempts + " attempts to guess the number.");

            for(int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt "+ attempts + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! you gussed the Number " + randomNumber + "correctly!");
                    System.out.println("your score for this round:" + score);
                    totalScore += score;
                    break;

                } else if (userGuess < randomNumber) {
                    System.out.println("your guess is too low.\n");
                }else {
                    System.out.println("your guess is too high.\n");
                }

                score -= 20; //reduce score for each incorrect guess
            }

            if (score <= 0) {
                System.out.println("round over! the correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nAll rounds are finished!");
        System.out.println("your total score: " + totalScore);

        sc.close();

        }
    }

    