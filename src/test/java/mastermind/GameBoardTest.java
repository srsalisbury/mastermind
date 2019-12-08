package mastermind;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.truth.Correspondence;
import org.junit.jupiter.api.Test;

public class GameBoardTest {

  static final Correspondence<Turn, PieceSet> HAS_GUESS =
      Correspondence.transforming(Turn::guess, "has guess");

  @Test
  public void addGuessAddsTurn() {
    PieceSet solution = new PieceSet("RGRP");
    PieceSet guess1 = new PieceSet("RGPY");
    PieceSet guess2 = new PieceSet("WGYP");
    GameBoard board = new GameBoard(solution);
    assertThat(board.getTurns()).isEmpty();
    board.addGuess(guess1);
    assertThat(board.getTurns()).comparingElementsUsing(HAS_GUESS).containsExactly(guess1);
    board.addGuess(guess2);
    assertThat(board.getTurns()).comparingElementsUsing(HAS_GUESS).containsExactly(guess1, guess2);
  }

  @Test
  public void addGuessReturnsResult() {
    PieceSet solution = new PieceSet("YGYP");
    PieceSet guess = new PieceSet("YWPY");
    Result expectedResult = Result.create(1, 2);
    GameBoard board = new GameBoard(solution);
    assertThat(board.addGuess(guess)).isEqualTo(expectedResult);
  }

  @Test
  public void hasWon() {
    PieceSet solution = new PieceSet("WGYP");
    PieceSet wrongGuess1 = new PieceSet("ROGY");
    PieceSet wrongGuess2 = new PieceSet("OGYW");
    GameBoard board = new GameBoard(solution);
    assertThat(board.hasWon()).isFalse();
    board.addGuess(wrongGuess1);
    assertThat(board.hasWon()).isFalse();
    board.addGuess(solution);
    assertThat(board.hasWon()).isTrue();
    board.addGuess(wrongGuess2);
    assertThat(board.hasWon()).isTrue();
  }

  @Test
  public void toStringTest() {
    PieceSet solution = new PieceSet("WRGY");
    PieceSet guess1 = new PieceSet("RRGO");
    PieceSet guess2 = new PieceSet("OGYW");
    GameBoard board = new GameBoard(solution);
    assertThat(board.toString()).isEqualTo("");
    board.addGuess(guess1);
    assertThat(board.toString()).isEqualTo("R R G O - 2 0\n");
    board.addGuess(guess2);
    assertThat(board.toString()).isEqualTo("R R G O - 2 0\nO G Y W - 0 3\n");
  }
}
