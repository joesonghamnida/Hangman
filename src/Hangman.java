import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by joe on 9/19/16.
 */
public class Hangman {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ArrayList<String> wordList = new ArrayList<>(Arrays.asList("ability","account","acquire","adverse"));
    static ArrayList<String> board = new ArrayList<>(Arrays.asList("_", "_", "_", "_", "_","_","_"));

    static String victoryCheck = "";

    //pick random word out of list
    static Random random = new Random();
    static String randomWord = wordList.get(random.nextInt(wordList.size() - 1));

    //used to select which hangman graphic to dispay
    static int wrongChoice = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        displayInstructions();

        for (int i = 10; i > 0; i--) {

            boolean correct = false;

            System.out.println("Guess");
            String playerGuess = scanner.nextLine();

            victoryCheck = "";
            victoryCheck();

            //go thru word and check if player guess matches a letter in the random word
            for (int j = 0; j < randomWord.length(); j++) {
                if (playerGuess.equals(randomWord.substring(j, j + 1))) {
                    board.set(j, playerGuess);
                    System.out.println(board);
                    System.out.printf("You have %d guesses left!\n", i - 1);
                    correct = true;
                }
            }
            if (!correct) {
                wrongChoice++;
                graphics();
                System.out.printf("You have %d guesses left!\n", i - 1);
            }
        }
        System.out.println("Thank you for playing!");
    }

    public static void displayInstructions() {
        System.out.println(ANSI_BLUE + "Greetings. You have 10 attempts to save this man's life" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Here's how it works:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "You may pick either a letter to guess" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "If you guess incorrectly, the incorrect letters will be " +
                "displayed for your future reference" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "If your guess is correct, the letters will be displayed " +
                "in their appropriate place on the board" + ANSI_RESET);
        System.out.println("-----");
    }

    //victory check condition
    public static void victoryCheck() {
        for (String s : board) {
            victoryCheck = victoryCheck + s;
            if (victoryCheck.equalsIgnoreCase(randomWord)) {
                System.out.println("You win!");
                break;
            }
        }
    }

    //switch cases for displaying the hangman graphics
    public static void graphics() {
        switch (wrongChoice) {
            case 1:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 2:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 3:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\         |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 4:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\|        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 5:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 6:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 7:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        " |        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 8:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        " ||       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 9:
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        " ||       |\n" +
                        "/         |\n" +
                        "          |\n" +
                        "------------------------");
                break;
            case 10:
                System.out.println("GAME OVER");
                System.out.println("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        " ||       |\n" +
                        "/  \\      |\n" +
                        "          |\n" +
                        "------------------------");
                break;
        }
    }
}

