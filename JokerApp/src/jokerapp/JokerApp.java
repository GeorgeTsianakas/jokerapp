package jokerapp;

/**
 * The program represents a lottery game. For each game, the user has to select
 * at least 5 numbers up to 45 numbers from 1-45 and additionally at least 1 up
 * to 20 numbers from 1-20. Then the program makes a draw to produce the winning
 * numbers (5 numbers from 1-45 plus one number from 1-20) and announces the
 * winners if any and how many numbers they have selected successfully. The
 * program also calculates the cost of each game.
 */
public class JokerApp {

    public static void main(String[] args) {

        Utils u = new Utils();
        u.letsPlay();

    }

}
