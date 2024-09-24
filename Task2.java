import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private static final int minimum_range = 1;
    private static final int maximum_range = 100;
    private static final int maximum_attempts = 10;
    private static final int maximum_rounds = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int total_score = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of Rounds : 3");
        System.out.println("Attempts To Guess Number In Each Round : 10\n");
        for (int i = 1; i <= maximum_rounds; i++) {
            int number = random.nextInt(maximum_range) + minimum_range;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, minimum_range, maximum_range,
                    maximum_attempts);
            while (attempts < maximum_attempts) {
                System.out.println("Enter your guess : ");
                int guess_the_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_the_number == number) {
                    int score = maximum_attempts - attempts;
                    total_score = total_score + score;
                    System.out.printf("Hurray! Number Guessed Successfully. Attempts = %d. Round Score = %d\n",
                            attempts, score);
                    break;
                }

                else if (guess_the_number < number) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_the_number,
                            maximum_attempts - attempts);
                }

                else if (guess_the_number > number) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_the_number,
                            maximum_attempts - attempts);
                }

            }

            if (attempts == maximum_attempts) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", total_score);
        scanner.close();
    }
}