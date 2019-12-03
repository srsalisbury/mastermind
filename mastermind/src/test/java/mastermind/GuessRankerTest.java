package mastermind;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GuessRankerTest {

  @ParameterizedTest(name = "rankGuess(solution={0}, guess={1}) is ({2},{3}).")
  @CsvSource({
    "rygp, rgwp, 2, 1",
    "rrrr, rgwp, 1, 0",
    "yyyy, rgwp, 0, 0",
    "rygp, rrrr, 1, 0",
    "rygr, rrww, 1, 1",
    "rrgg, rgrg, 2, 2"
  })
  void rankGuess(
      String solutionString,
      String guessString,
      int expectedNumPiecesRightPlace,
      int expectedNumPiecesWrongPlace) {
    Result result = GuessRanker.rankGuess(new PieceSet(solutionString), new PieceSet(guessString));
    assertThat(result.numPiecesRightPlace()).isEqualTo(expectedNumPiecesRightPlace);
    assertThat(result.numPiecesWrongPlace()).isEqualTo(expectedNumPiecesWrongPlace);
  }
}
