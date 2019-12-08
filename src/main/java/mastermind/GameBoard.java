package mastermind;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

  private final PieceSet solution;
  private List<Turn> turns = new ArrayList<>();

  public GameBoard(PieceSet theSolution) {
    solution = theSolution;
  }

  public Result addGuess(PieceSet guess) {
    Result result = GuessRanker.rankGuess(solution, guess);
    Turn turn = Turn.create(guess, result);
    turns.add(turn);
    return result;
  }

  public List<Turn> getTurns() {
    return turns;
  }

  public boolean hasWon() {
    for (Turn turn : turns) {
      if (turn.isCorrect()) {
        return true;
      }
    }
    return false;
  }

  public void print() {
    for (Turn turn : turns) {
      System.out.println(turn + "\n");
    }
  }
}
