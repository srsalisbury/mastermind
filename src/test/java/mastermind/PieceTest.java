package mastermind;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PieceTest {

  @Test
  void fromChar() {
    assertThat(Piece.fromChar('R')).isEqualTo(Piece.RED);
    assertThat(Piece.fromChar('P')).isEqualTo(Piece.PURPLE);
    assertThat(Piece.fromChar('r')).isEqualTo(Piece.RED);
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          Piece.fromChar('X');
        });
  }

  @Test
  public void toStringTest() {
    assertThat(Piece.RED.toString()).isEqualTo("R");
    assertThat(Piece.PURPLE.toString()).isEqualTo("P");
    assertThat(Piece.GREEN.toString()).isEqualTo("G");
  }
}
