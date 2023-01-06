public class Bishop extends ChessPiece{


    public Bishop(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♝";
        if (this.getColor().equals(Color.WHITE)) printable = "♗";
    }



    public boolean move(ChessBoardSquare toSqaure) {
        return false;
    }
}
