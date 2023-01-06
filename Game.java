public class Game {

    private ChessBoard board;
    private Player p1;
    private Player p2;

    public Game() {
        board = new ChessBoard(true);
        p1 = new Player(ChessPiece.Color.WHITE, this);
        p2 = new Player(ChessPiece.Color.BLACK, this);
    }

    public ChessBoard getBoard() {return board;}
    public Player getP1() {
        return p1;
    }
    public Player getP2() {
        return p2;
    }
}
