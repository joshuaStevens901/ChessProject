public class Knight extends ChessPiece{


    public Knight(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.WHITE)) printable = "♘";
        if (this.getColor().equals(Color.BLACK)) printable = "♞";
    }

    public boolean move(ChessBoardSquare toSqaure) {
        return false;
    }
}
