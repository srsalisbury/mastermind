package mastermind;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Result {

  public static Result create(int numPiecesRightPlace, int numPiecesWrongPlace) {
    return new AutoValue_Result(numPiecesRightPlace, numPiecesWrongPlace);
  }

  public abstract int numPiecesRightPlace();

  public abstract int numPiecesWrongPlace();

  public boolean hasWon() {
    return numPiecesRightPlace() == PieceSet.setLength;
  }
}
