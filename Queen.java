import java.util.ArrayList;

public class Queen extends ChessPiece{


    public Queen(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♕";
        if (this.getColor().equals(Color.WHITE)) printable = "♛";
    }



    @Override
    public boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException{
        ArrayList<ChessBoardSquare> validMoves = new ArrayList<>();
        boolean invalid = true;

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
        if (square.hasEast() && square.hasNorth()) {
            //northeast
            do {
                square = square.getEast().getNorth();
                validMoves.add(square);
            }
            while (square.hasEast() && square.hasNorth() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //southeast
        if (square.hasEast() && square.hasSouth()) {
            do {
                square = square.getEast().getSouth();
                validMoves.add(square);
            }
            while (square.hasEast() && square.hasSouth() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //southwest
        if (square.hasSouth() && square.hasWest()) {
            do {
                square = square.getSouth().getWest();
                validMoves.add(square);
            }
            while (square.hasSouth() && square.hasWest() && !square.hasPiece());
            square = getCurrentSquare();
        }
        //northwest
        if (square.hasWest() && square.hasNorth()) {
            do {
                square = square.getNorth().getWest();
                validMoves.add(square);
            }
            while (square.hasWest() && square.hasNorth() && !square.hasPiece());
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
