public abstract class ChessPiece {


    private ChessBoardSquare currentSquare;
    private final ChessBoard board;
    private final Color color;
    private Player owner;
    private Player opponent;

    public enum Color {BLACK, WHITE}
    public enum piece {KNIGHT, BISHOP, ROOK, QUEEN}

    String printable;

    InvalidMoveException notInMoveSet = new InvalidMoveException("The move was not in compliance with the " + this.getClass().toString().substring(6)  + "'s moveset");
    InvalidMoveException friendlyFire = new InvalidMoveException("The " + this.getClass().toString().substring(6) + " attempted to capture a friendly piece");


    public ChessPiece(ChessBoard board, ChessBoardSquare currentSquare, Color color) {
        this.board = board;
        this.currentSquare = currentSquare;
        this.color = color;

    }
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
            throw new InvalidMoveException("THROWN BY MOVE METHOD");
        }
        return captured;
    }
    public abstract boolean isValidMove(ChessBoardSquare toSquare) throws InvalidMoveException;

    public void passiveMove(ChessBoardSquare toSquare) {
        getCurrentSquare().setPiece(null);
        setCurrentSquare(toSquare);
        currentSquare.setPiece(this);
    }

    public void capture(ChessBoardSquare target) throws GameEndException{
        ChessPiece targetPiece = target.getPiece();
        if (targetPiece.getClass().equals(King.class)) throw new GameEndException("WIN" + getOwner().getName());

        getCurrentSquare().setPiece(null);
        setCurrentSquare(target);
        target.getPiece().setCurrentSquare(null);
        target.setPiece(this);

        targetPiece.getOwner().removePiece(targetPiece);
    }



    public ChessBoard getBoard() {
        return board;
    }

    public ChessBoardSquare getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(ChessBoardSquare currentSquare) {
        this.currentSquare = currentSquare;
    }

    public Color getColor() {
        return color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {this.owner = owner;}

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {this.opponent = opponent;}

    public String toString() {
        return color.toString() + " " + String.valueOf(this.getClass()).substring(6);
    }
}
