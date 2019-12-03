package mastermind;

public class PieceSet {

  public static final int setLength = 4;
  private Piece[] pieces = new Piece[setLength];

  public PieceSet(Piece[] thePieces) {
    if (thePieces.length != setLength) {
      throw new IllegalArgumentException("Wrong number of Pieces in given array");
    }
    for (int i = 0; i < setLength; i++) {
      pieces[i] = thePieces[i];
    }
  }

  public PieceSet(String thePieces) {
    if (thePieces.length() != setLength) {
      throw new IllegalArgumentException("Wrong number of charaters in given string");
    }
    for (int i = 0; i < setLength; i++) {
      pieces[i] = Piece.fromChar(thePieces.charAt(i));
    }
  }

  public Piece getPiece(int index) {
    return pieces[index];
  }

  public int size() {
    return pieces.length;
  }

  public boolean equals(Object other) {
    if (!(other instanceof PieceSet)) {
      return false;
    }
    PieceSet otherPieces = (PieceSet) other;
    return java.util.Arrays.equals(pieces, otherPieces.pieces);
  }
}
