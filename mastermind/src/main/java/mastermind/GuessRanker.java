package mastermind;

import java.util.ArrayList;
import java.util.List;

public class GuessRanker {
  private final PieceSet solution;

  public GuessRanker(PieceSet theSolution) {
    solution = theSolution;
  }

  public Result rankGuess(PieceSet guess) {
    return rankGuess(solution, guess);
  }

  public static Result rankGuess(PieceSet solution, PieceSet guess) {
    if (solution.size() != guess.size()) {
      throw new IllegalArgumentException("Lengths of guess and solution do not match");
    }
    List<Piece> workingSolution = new ArrayList<>();
    List<Piece> workingGuess = new ArrayList<>();
    int rightPlacePieces = 0;
    int wrongPlacePieces = 0;
    for (int i = 0; i < solution.size(); i++) {
      workingSolution.add(solution.getPiece(i));
      workingGuess.add(guess.getPiece(i));
    }
    for (int i = 0; i < solution.size(); i++) {
      if (workingGuess.get(i) == workingSolution.get(i)) {
        rightPlacePieces++;
        workingSolution.set(i, null);
        workingGuess.set(i, null);
      }
    }
    for (int i = 0; i < solution.size(); i++) {
      Piece currentGuessPiece = workingGuess.get(i);
      if (currentGuessPiece != null) {
        if (workingSolution.contains(currentGuessPiece)) {
          wrongPlacePieces++;
          workingSolution.remove(currentGuessPiece);
        }
      }
    }
    return Result.create(rightPlacePieces, wrongPlacePieces);
  }
}
