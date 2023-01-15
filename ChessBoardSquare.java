public class ChessBoardSquare {
    public enum Color {BROWN, WHITE}
    public enum ID {A1, A2, A3, A4, A5, A6, A7, A8, B1, B2, B3, B4, B5, B6, B7, B8, C1, C2, C3, C4, C5, C6, C7, C8, D1, D2, D3, D4, D5, D6, D7, D8, E1, E2, E3, E4, E5, E6, E7, E8, F1, F2, F3, F4, F5, F6, F7, F8, G1, G2, G3, G4, G5, G6, G7, G8, H1, H2, H3, H4, H5, H6, H7, H8}

    private final Color color;
    private ChessPiece piece;
    private ChessBoardSquare north;
    private ChessBoardSquare east;
    private ChessBoardSquare south;
    private ChessBoardSquare west;
    private final ID id;


    public ChessBoardSquare(Color color, ID id) {
        this.color = color;
        this.id = id;
    }
    public ChessBoardSquare(Color color, ChessPiece piece, ID id) {
        this.piece = piece;
        this.color = color;
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public ChessPiece getPiece() {
        return piece;
    }
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public ID getId() {
        return id;
    }
    
    public ChessBoardSquare getNorth() {
        return north;
    }

    public ChessBoardSquare getForward(ChessPiece.Color color) {
        if (color.equals(ChessPiece.Color.WHITE)) return getNorth();
        else return getSouth();
    }

    public boolean hasForward(ChessPiece.Color color) {
        if (color.equals(ChessPiece.Color.WHITE)) return hasNorth();
        else return hasSouth();
    }

    public void setNorth(ChessBoardSquare north) {
        this.north = north;
        if (north.getSouth() != this) north.setSouth(this);
    }

    public ChessBoardSquare getEast() {
        return east;
    }
    public void setEast(ChessBoardSquare east) {
        this.east = east;
        if (east.getWest() != this) east.setWest(this);
    }

    public ChessBoardSquare getSouth() {
        return south;
    }
    public void setSouth(ChessBoardSquare south) {
        this.south = south;
        if (south.getNorth() != this) south.setNorth(this);
    }

    public ChessBoardSquare getWest() {
        return west;
    }
    public void setWest(ChessBoardSquare west) {
        this.west = west;
        if (west.getEast() != this) west.setEast(this);
    }
    public boolean hasNorth() {
        return north != null;
    }
    public boolean hasEast() {
        return east != null;
    }
    public boolean hasSouth() {
        return south != null;
    }
    public boolean hasWest() {
        return west != null;
    }

    public String toString() {
        if (piece == null) return "ID: " + id.toString();
        return "ID: " + id.toString() + " Piece: " + piece.toString();
    }

    

}
