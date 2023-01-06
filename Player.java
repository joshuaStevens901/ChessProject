public class Player {


    ChessPiece pawnA, pawnB, pawnC, pawnD, pawnE, pawnF, pawnG, pawnH;

    ChessPiece rookA, rookH;

    ChessPiece knightB, knightG;

    ChessPiece bishopC, bishopF;

    ChessPiece king, queen;

    String name;

    Game game;
    ChessBoard board;

    private final ChessPiece.Color color;

    public Player(ChessPiece.Color color, Game game) {
        this.color = color;
        this.game = game;
        board = game.getBoard();

        if (color.equals(ChessPiece.Color.WHITE)) {
            pawnA = board.A2.getPiece();
            pawnB = board.B2.getPiece();
            pawnC = board.C2.getPiece();
            pawnD = board.D2.getPiece();
            pawnE = board.E2.getPiece();
            pawnF = board.F2.getPiece();
            pawnG = board.G2.getPiece();
            pawnH = board.H2.getPiece();
            
            rookA = board.A1.getPiece();
            rookH = board.H1.getPiece();
            
            knightB = board.B1.getPiece();
            knightG = board.G1.getPiece();
            
            bishopC = board.C1.getPiece();
            bishopF = board.F1.getPiece();
            
            king = board.E1.getPiece();
            queen = board.D1.getPiece();
        }
        if (color.equals(ChessPiece.Color.BLACK)) {
            pawnA = board.A7.getPiece();
            pawnB = board.B7.getPiece();
            pawnC = board.C7.getPiece();
            pawnD = board.D7.getPiece();
            pawnE = board.E7.getPiece();
            pawnF = board.F7.getPiece();
            pawnG = board.G7.getPiece();
            pawnH = board.H7.getPiece();

            rookA = board.A8.getPiece();
            rookH = board.H8.getPiece();

            knightB = board.B8.getPiece();
            knightG = board.G8.getPiece();

            bishopC = board.C8.getPiece();
            bishopF = board.F8.getPiece();

            king = board.E8.getPiece();
            queen = board.D8.getPiece();
        }
    }

    public void getPlayerName() {

    }


    public ChessPiece.Color getColor() {return color;}
}
