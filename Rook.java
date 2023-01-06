public class Rook extends ChessPiece{


    public Rook(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.WHITE)) printable = "♖";
        if (this.getColor().equals(Color.BLACK)) printable = "♜";
    }


    @Override
    public boolean move(ChessBoardSquare toSqaure) {
        return false;
    }
}