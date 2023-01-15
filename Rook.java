import java.util.ArrayList;

public class Rook extends ChessPiece{


    public Rook(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♖";
        if (this.getColor().equals(Color.WHITE)) printable = "♜";
    }



    @Override
    public boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException{
        boolean invalid = true;
        ArrayList<ChessBoardSquare> validMoves = new ArrayList<>();
        ChessBoardSquare square = getCurrentSquare();


        //north
        if (square.hasNorth()) {
            do {
                square = square.getNorth();
                validMoves.add(square);
            }
            while (square.hasNorth() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //east
        if (square.hasEast()) {
            do {
                square = square.getEast();
                validMoves.add(square);
            }
            while (square.hasEast() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //south
        if (square.hasSouth()) {
            do {
                square = square.getSouth();
                validMoves.add(square);
            }
            while (square.hasSouth() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //west
        if (square.hasWest()) {
            do {
                square = square.getWest();
                validMoves.add(square);
            }
            while (square.hasWest() && !square.hasPiece());
            square = getCurrentSquare();
        }

        for (ChessBoardSquare s : validMoves) {
            if (toSquare.equals(s)) {
                invalid = false;
                break;
            }
        }

        if (invalid) throw notInMoveSet;

        if (toSquare.hasPiece()) if (toSquare.getPiece().getColor().equals(getColor())) throw friendlyFire;

        return true;
    }
}
