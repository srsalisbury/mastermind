package mastermind;

public enum Piece {
  RED,
  ORANGE,
  YELLOW,
  GREEN,
  PURPLE,
  WHITE;

  public static Piece fromChar(char theChar) {
    theChar = Character.toUpperCase(theChar);
    switch (theChar) {
      case 'R':
        return Piece.RED;
      case 'O':
        return Piece.ORANGE;
      case 'Y':
        return Piece.YELLOW;
      case 'G':
        return Piece.GREEN;
      case 'P':
        return Piece.PURPLE;
      case 'W':
        return Piece.WHITE;
      default:
        throw new IllegalArgumentException("Character given does not match any Piece Color");
    }
  }
}
