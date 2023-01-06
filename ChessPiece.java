public abstract class ChessPiece {


    private ChessBoardSquare currentSqaure;
    private final ChessBoard board;
    private final Color color;

    public enum Color {BLACK, WHITE}


    String printable;
    

    public ChessPiece(ChessBoard board, ChessBoardSquare currentSqaure, Color color) {
        this.board = board;
        this.currentSqaure = currentSqaure;
        this.color = color;
    }
    public abstract boolean move(ChessBoardSquare toSqaure);

    public void capture() {
    };


    public ChessBoard getBoard() {
        return board;
    }

    public ChessBoardSquare getCurrentSqaure() {
        return currentSqaure;
    }

    public void setCurrentSqaure(ChessBoardSquare currentSqaure) {
        this.currentSqaure = currentSqaure;
        if (currentSqaure.getPiece() != this) currentSqaure.setPiece(this);
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return color.toString() + " " + String.valueOf(this.getClass()).substring(6);
    }
}
