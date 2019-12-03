package mastermind;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PieceSetTest {

  @Test
  public void constructor() {
    assertThat(new PieceSet("rgpr"))
        .isEqualTo(new PieceSet(new Piece[] {Piece.RED, Piece.GREEN, Piece.PURPLE, Piece.RED}));
    assertThat(new PieceSet("gpgy"))
        .isEqualTo(
            new PieceSet(new Piece[] {Piece.GREEN, Piece.PURPLE, Piece.GREEN, Piece.YELLOW}));
    assertThat(new PieceSet("gPgY"))
        .isEqualTo(
            new PieceSet(new Piece[] {Piece.GREEN, Piece.PURPLE, Piece.GREEN, Piece.YELLOW}));
  }

  @Test
  public void constructor_tooManyCharacters() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new PieceSet("gpgyr");
        });
  }

  @Test
  public void constructor_invalidCharater() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new PieceSet("xgpr");
        });
  }
}
