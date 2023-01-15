import java.util.ArrayList;
import java.util.Set;

public class King extends ChessPiece {

    InvalidMoveException inCheck = new InvalidMoveException("The move would have put your King in check");


    public King(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♔";
        if (this.getColor().equals(Color.WHITE)) printable = "♚";
    }

    @Override
    public boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException{
        boolean invalid = true;
        ArrayList<ChessBoardSquare> validMoves= new ArrayList<>();
        
        if (getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getNorth());
        if (getCurrentSquare().hasWest()) validMoves.add(getCurrentSquare().getWest());
        if (getCurrentSquare().hasEast()) validMoves.add(getCurrentSquare().getEast());
        if (getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getSouth());
        if (getCurrentSquare().hasEast() && getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getEast().getNorth());
        if (getCurrentSquare().hasEast() && getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getEast().getSouth());
        if (getCurrentSquare().hasWest() && getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getWest().getNorth());
        if (getCurrentSquare().hasWest() && getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getWest().getSouth());


        for (ChessBoardSquare s : validMoves) {
            if (toSquare.equals(s)) {
                invalid = false;
                break;
            }
        }

        if (invalid) throw notInMoveSet;

        if (toSquare.hasPiece()) if (toSquare.getPiece().getColor().equals(getColor())) throw friendlyFire;

        if (isInCheck(toSquare)) throw inCheck;

        return true;
    }

    public boolean isInCheck(ChessBoardSquare checkSquare) {


        for (ChessPiece s : getOpponent()) {

            System.out.println(s);
            try {
                if (s.isValidMove(checkSquare)) {
                    return true;
                }
            }
            catch (InvalidMoveException ignored) {
            }
        }
        return false;
    }

    public boolean isInStaleMate() {

        if (getOwner().getNumberOfPieces() > 1) return false;

        ArrayList<ChessBoardSquare> validMoves= new ArrayList<>();
        ArrayList<ChessBoardSquare> removeList = new ArrayList<>();

        if (getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getNorth());
        if (getCurrentSquare().hasWest()) validMoves.add(getCurrentSquare().getWest());
        if (getCurrentSquare().hasEast()) validMoves.add(getCurrentSquare().getEast());
        if (getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getSouth());
        if (getCurrentSquare().hasEast() && getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getEast().getNorth());
        if (getCurrentSquare().hasEast() && getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getEast().getSouth());
        if (getCurrentSquare().hasWest() && getCurrentSquare().hasNorth()) validMoves.add(getCurrentSquare().getWest().getNorth());
        if (getCurrentSquare().hasWest() && getCurrentSquare().hasSouth()) validMoves.add(getCurrentSquare().getWest().getSouth());

        for (ChessBoardSquare s : validMoves) if (s.hasPiece()) if (s.getPiece().getColor().equals(getColor())) removeList.add(s);

        validMoves.removeAll(removeList);

        for (ChessBoardSquare s : validMoves) {
            if (!isInCheck(s)) {
                return false;
            }
        }
        return true;
    }
}
