package mastermind;

import java.util.Scanner;

public class GameMaster {

  private GameBoard board;
  private Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    new GameMaster().startGame();
  }

  public GameMaster() {
    PieceSet solution = PieceSet.makeRandom();
    board = new GameBoard(solution);
  }

  public void startGame() {
    System.out.println("Welcome to MasterMind!");
    System.out.println("To play, enter a four-letter guess when prompted");
    System.out.println(
        "The possible guesses are [R]ed, [O]range, [Y]ellow, [G]reen, [P]urple, and [W]hite");
    System.out.println(
        "The game will tell you if you've won, or it will show your past guesses and their results");
    System.out.println("Have fun!");
    playGame();
  }

  public void playGame() {
    while (true) {
      System.out.print("Enter a guess: ");
      PieceSet guess;
      try {
        guess = new PieceSet(input.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("You entered an invalid guess for the reason: " + e.getMessage());
        continue;
      }
      board.addGuess(guess);
      if (board.hasWon()) {
        System.out.println(
            "Congratulations! You guessed " + guess + "in " + board.numTurns() + " guesses!");
        break;
      } else {
        System.out.println(board);
      }
    }
  }
}
