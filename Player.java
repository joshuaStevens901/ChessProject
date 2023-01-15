import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Player implements Iterable<ChessPiece>{

    private ArrayList<ChessPiece> pieces = new ArrayList<>();


    private String name;

    private Game game;
    private ChessBoard board;
    private Player opponent;
    private King king;

    private final ChessPiece.Color color;

    public Player(ChessPiece.Color color, Game game) {
        this.color = color;
        this.game = game;
    }

    public void setupPlayer() {
        board = game.getBoard();
        if (color.equals(ChessPiece.Color.WHITE)) {
            opponent = getGame().getP2();
            board.traverseBoardForward(s -> {
                if (s.hasPiece()) {
                    if (s.getPiece().getColor().equals(ChessPiece.Color.WHITE)) {
                        s.getPiece().setOwner(this);
                        s.getPiece().setOpponent(opponent);
                        addPiece(s.getPiece());
                    }
                }
            });
        }
        if (color.equals(ChessPiece.Color.BLACK)) {
            opponent = getGame().getP1();
            board.traverseBoardForward(s -> {
                if (s.hasPiece()) {
                    if (s.getPiece().getColor().equals(ChessPiece.Color.BLACK)) {
                        s.getPiece().setOwner(this);
                        s.getPiece().setOpponent(opponent);
                        addPiece(s.getPiece());
                    }
                }
            });
        }
        for (ChessPiece p : pieces) {
            if (p.getClass().equals(King.class)) {
                king = (King)p;
            }
        }
    }

    public Game getGame() { return game; }

    public ChessBoard getBoard() { return board; }


    public ChessPiece.Color getColor() {return color;}

    public void addPiece(ChessPiece newPiece) {

        if (newPiece.getColor().equals(color)) {
            pieces.add(newPiece);
        }
        else throw new IllegalArgumentException();
    }

    public void removePiece(ChessPiece piece) {
        if (!pieces.remove(piece)) throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public King getKing () {return king;}

    public boolean isKingInStalemate() {
        return king.isInStaleMate();
    }

    public void setName(String name) {this.name = name;}

    public Player getOpponent() {return opponent;}

    public int getNumberOfPieces() {
        return pieces.size();
    }

    @Override
    public Iterator<ChessPiece> iterator() {
        return pieces.iterator();
    }

    public String toString() {
        if (color.equals(ChessPiece.Color.WHITE)) return "P1, " + color;
        if (color.equals(ChessPiece.Color.BLACK)) return "P2, " + color;
        else throw new IllegalStateException();
    }


}
