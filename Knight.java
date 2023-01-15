import java.util.ArrayList;

public class Knight extends ChessPiece{


    public Knight(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♘";
        if (this.getColor().equals(Color.WHITE)) printable = "♞";
    }

    @Override
    public boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException{


        ArrayList<ChessBoardSquare> validMoves = new ArrayList<>();
        boolean invalid = true;

        try {
            validMoves.add(getCurrentSquare().getNorth().getNorth().getEast()); //north two, east one
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getNorth().getEast().getEast()); //north one, east two
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getSouth().getEast().getEast()); //south one, east two
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getSouth().getSouth().getEast()); //south two, east one
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getSouth().getSouth().getWest()); //south two, west one
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getSouth().getWest().getWest()); //south one, west two
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getNorth().getWest().getWest()); //north one, west two
        }
        catch (NullPointerException ignored) {
        }
        try {
            validMoves.add(getCurrentSquare().getNorth().getNorth().getWest()); //north two, west one
        }
        catch (NullPointerException ignored) {
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
