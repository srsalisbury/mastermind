package mastermind;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Turn {

  public static Turn create(PieceSet guess, Result result) {
    return new AutoValue_Turn(guess, result);
  }

  public abstract PieceSet guess();

  public abstract Result result();

  public boolean isCorrect() {
    return result().isCorrect();
  }

  public String toString() {
  	return "" + guess() + result();
  }
}
