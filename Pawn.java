import java.util.ArrayList;
import java.util.Scanner;

public class Pawn extends ChessPiece{

    private boolean hasMoved = false;
    private ChessPiece.piece upgradeDecision;

    private InvalidMoveException emptyCaptureAttempt = new InvalidMoveException("The Pawn tried to capture a square with no piece");
    private InvalidMoveException forwardCaptureAttempt = new InvalidMoveException("The Pawn tried to move forward into a square blocked by another piece");
    private InvalidMoveException invalidDoubleMove = new InvalidMoveException("THe Pawn can only move two squares on its first move");

    public Pawn(ChessBoard board, ChessBoardSquare currentSqaure, ChessPiece.Color color) {
        super(board, currentSqaure, color);

        if (this.getColor().equals(Color.BLACK)) printable = "♙";
        if (this.getColor().equals(Color.WHITE)) printable = "♟︎";
    }
    @Override
    public boolean move(ChessBoardSquare toSquare) throws InvalidMoveException, GameEndException{
        boolean captured = false;
        if (isValidMove(toSquare)) {
            if (toSquare.hasPiece()) {
                capture (toSquare);
                captured = true;
            }
            else {
                passiveMove(toSquare);
            }
        }
        else {
            throw new InvalidMoveException();
        }

        if (!toSquare.hasNorth()) {
            upgrade(getUpgradeDecision());
        }

        hasMoved = true;
        return captured;
    }

    public void upgrade(ChessPiece.piece toPieceToken) {
        ChessPiece newPiece;

        if (toPieceToken.equals(piece.QUEEN)) newPiece = new Queen(getBoard(), getCurrentSquare(), getColor());
        else if (toPieceToken.equals(piece.ROOK)) newPiece = new Rook(getBoard(), getCurrentSquare(),getColor());
        else if (toPieceToken.equals(piece.BISHOP)) newPiece = new Bishop(getBoard(), getCurrentSquare(),getColor());
        else if (toPieceToken.equals(piece.KNIGHT)) newPiece = new Knight(getBoard(), getCurrentSquare(), getColor());
        else newPiece = new Queen(getBoard(), getCurrentSquare(), getColor());
        newPiece.getCurrentSquare().setPiece(newPiece);
        setCurrentSquare(null);
        getOwner().addPiece(newPiece);
        getOwner().removePiece(this);

    }
    @Override
    public boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException{
        boolean invalid = true;
        if (toSquare.equals(getCurrentSquare().getForward(getColor()).getForward(getColor()))) {
            if (!hasMoved) {
                if (getCurrentSquare().getForward(getColor()).hasPiece()) throw forwardCaptureAttempt;
                if (getCurrentSquare().getForward(getColor()).getForward(getColor()).hasPiece())
                    throw forwardCaptureAttempt;
                return true;
            }
            throw invalidDoubleMove;
        }

        ArrayList<ChessBoardSquare> validMoves = new ArrayList<>();

        if (getCurrentSquare().hasForward(getColor())) validMoves.add(getCurrentSquare().getForward(getColor()));
        if (getCurrentSquare().getForward(getColor()).hasEast()) validMoves.add(getCurrentSquare().getForward(getColor()).getEast());
        if (getCurrentSquare().getForward(getColor()).hasWest()) validMoves.add(getCurrentSquare().getForward(getColor()).getWest());


        for (ChessBoardSquare s : validMoves) {
            if (toSquare.equals(s)) {
                invalid = false;
                break;
            }
        }

        if (invalid) throw notInMoveSet;

        if (toSquare.equals(validMoves.get(0)) && validMoves.get(0).hasPiece()) throw forwardCaptureAttempt;

        if (toSquare.equals(validMoves.get(2)) && !validMoves.get(2).hasPiece()) throw emptyCaptureAttempt;

        if (toSquare.equals(validMoves.get(2))) if (validMoves.get(2).getPiece().getColor().equals(getColor())) throw friendlyFire;

        if (toSquare.equals(validMoves.get(1)) && !validMoves.get(1).hasPiece()) throw emptyCaptureAttempt;

        if (toSquare.equals(validMoves.get(1))) if (validMoves.get(1).getPiece().getColor().equals(getColor())) throw friendlyFire;

        return true;
    }

    public piece getUpgradeDecision() {
        Scanner scan = new Scanner(System.in);
        String playerIn = "";
        System.out.print("What piece would you like to upgrade your pawn to?\n(KNIGHT/ROOK/BISHOP/QUEEN)\n>");
        while (true) {
            playerIn = scan.nextLine();
            for (ChessPiece.piece t : ChessPiece.piece.values()) if (t.toString().equals(playerIn)) {
                return t;
            }
            System.out.print("Please enter one of the valid pieces bellow(KNIGHT/ROOK/BISHOP/QUEEN)\n>");
        }
    }

}
