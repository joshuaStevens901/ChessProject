import java.util.ArrayList;

public class ChessBoard{


    private Game game;

    ChessBoardSquare A1 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.A1);
    ChessBoardSquare A2 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.A2);
    ChessBoardSquare A3 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.A3);
    ChessBoardSquare A4 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.A4);
    ChessBoardSquare A5 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.A5);
    ChessBoardSquare A6 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.A6);
    ChessBoardSquare A7 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.A7);
    ChessBoardSquare A8 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.A8);

    ChessBoardSquare B1 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.B1);
    ChessBoardSquare B2 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.B2);
    ChessBoardSquare B3 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.B3);
    ChessBoardSquare B4 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.B4);
    ChessBoardSquare B5 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.B5);
    ChessBoardSquare B6 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.B6);
    ChessBoardSquare B7 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.B7);
    ChessBoardSquare B8 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.B8);

    ChessBoardSquare C1 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.C1);
    ChessBoardSquare C2 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.C2);
    ChessBoardSquare C3 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.C3);
    ChessBoardSquare C4 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.C4);
    ChessBoardSquare C5 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.C5);
    ChessBoardSquare C6 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.C6);
    ChessBoardSquare C7 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.C7);
    ChessBoardSquare C8 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.C8);

    ChessBoardSquare D1 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.D1);
    ChessBoardSquare D2 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.D2);
    ChessBoardSquare D3 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.D3);
    ChessBoardSquare D4 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.D4);
    ChessBoardSquare D5 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.D5);
    ChessBoardSquare D6 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.D6);
    ChessBoardSquare D7 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.D7);
    ChessBoardSquare D8 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.D8);

    ChessBoardSquare E1 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.E1);
    ChessBoardSquare E2 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.E2);
    ChessBoardSquare E3 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.E3);
    ChessBoardSquare E4 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.E4);
    ChessBoardSquare E5 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.E5);
    ChessBoardSquare E6 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.E6);
    ChessBoardSquare E7 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.E7);
    ChessBoardSquare E8 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.E8);

    ChessBoardSquare F1 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.F1);
    ChessBoardSquare F2 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.F2);
    ChessBoardSquare F3 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.F3);
    ChessBoardSquare F4 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.F4);
    ChessBoardSquare F5 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.F5);
    ChessBoardSquare F6 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.F6);
    ChessBoardSquare F7 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.F7);
    ChessBoardSquare F8 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.F8);

    ChessBoardSquare G1 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.G1);
    ChessBoardSquare G2 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.G2);
    ChessBoardSquare G3 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.G3);
    ChessBoardSquare G4 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.G4);
    ChessBoardSquare G5 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.G5);
    ChessBoardSquare G6 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.G6);
    ChessBoardSquare G7 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.G7);
    ChessBoardSquare G8 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.G8);

    ChessBoardSquare H1 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.H1);
    ChessBoardSquare H2 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.H2);
    ChessBoardSquare H3 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.H3);
    ChessBoardSquare H4 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.H4);
    ChessBoardSquare H5 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.H5);
    ChessBoardSquare H6 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.H6);
    ChessBoardSquare H7 = new ChessBoardSquare(ChessBoardSquare.Color.WHITE, ChessBoardSquare.ID.H7);
    ChessBoardSquare H8 = new ChessBoardSquare(ChessBoardSquare.Color.BROWN, ChessBoardSquare.ID.H8);
    
    
    public ChessBoard(boolean startup, Game game) {

        this.game = game;


        //ROW 8
        A8.setEast(B8);
        A8.setSouth(A7);

        B8.setEast(C8);
        B8.setSouth(B7);

        C8.setEast(D8);
        C8.setSouth(C7);

        D8.setEast(E8);
        D8.setSouth(D7);

        E8.setEast(F8);
        E8.setSouth(E7);

        F8.setEast(G8);
        F8.setSouth(E7);
        
        G8.setEast(H8);
        G8.setSouth(G7);
        
        H8.setSouth(H7);
        
        //ROW 7
        A7.setEast(B7);
        A7.setSouth(A6);

        B7.setEast(C7);
        B7.setSouth(B6);

        C7.setEast(D7);
        C7.setSouth(C6);

        D7.setEast(E7);
        D7.setSouth(D6);

        E7.setEast(F7);
        E7.setSouth(E6);

        F7.setEast(G7);
        F7.setSouth(F6);

        G7.setEast(H7);
        G7.setSouth(G6);
        
        H7.setSouth(H6);

        //ROW 6
        A6.setEast(B6);
        A6.setSouth(A5);

        B6.setEast(C6);
        B6.setSouth(B5);

        C6.setEast(D6);
        C6.setSouth(C5);

        D6.setEast(E6);
        D6.setSouth(D5);

        E6.setEast(F6);
        E6.setSouth(E5);

        F6.setEast(G6);
        F6.setSouth(F5);

        G6.setEast(H6);
        G6.setSouth(G5);

        H6.setSouth(H5);
        
        //ROW 5
        A5.setEast(B5);
        A5.setSouth(A4);

        B5.setEast(C5);
        B5.setSouth(B4);

        C5.setEast(D5);
        C5.setSouth(C4);

        D5.setEast(E5);
        D5.setSouth(D4);

        E5.setEast(F5);
        E5.setSouth(E4);

        F5.setEast(G5);
        F5.setSouth(F4);

        G5.setEast(H5);
        G5.setSouth(G4);

        H5.setSouth(H4);
        
        //ROW 4
        A4.setEast(B4);
        A4.setSouth(A3);

        B4.setEast(C4);
        B4.setSouth(B3);

        C4.setEast(D4);
        C4.setSouth(C3);

        D4.setEast(E4);
        D4.setSouth(D3);

        E4.setEast(F4);
        E4.setSouth(E3);

        F4.setEast(G4);
        F4.setSouth(F3);

        G4.setEast(H4);
        G4.setSouth(G3);

        H4.setSouth(H3);
        
        //ROW 3
        A3.setEast(B3);
        A3.setSouth(A2);

        B3.setEast(C3);
        B3.setSouth(B2);

        C3.setEast(D3);
        C3.setSouth(C2);

        D3.setEast(E3);
        D3.setSouth(D2);

        E3.setEast(F3);
        E3.setSouth(E2);

        F3.setEast(G3);
        F3.setSouth(F2);

        G3.setEast(H3);
        G3.setSouth(G2);

        H3.setSouth(H2);

        //ROW 2
        A2.setEast(B2);
        A2.setSouth(A1);

        B2.setEast(C2);
        B2.setSouth(B1);

        C2.setEast(D2);
        C2.setSouth(C1);

        D2.setEast(E2);
        D2.setSouth(D1);

        E2.setEast(F2);
        E2.setSouth(E1);

        F2.setEast(G2);
        F2.setSouth(F1);

        G2.setEast(H2);
        G2.setSouth(G1);

        H2.setSouth(H1);

        //ROW 1
        A1.setEast(B1);

        B1.setEast(C1);

        C1.setEast(D1);

        D1.setEast(E1);

        E1.setEast(F1);

        F1.setEast(G1);

        G1.setEast(H1);

        if (startup) {

            A8.setPiece(new Rook(this, A8, ChessPiece.Color.BLACK));
            B8.setPiece(new Knight(this, B8, ChessPiece.Color.BLACK));
            C8.setPiece(new Bishop(this, C8, ChessPiece.Color.BLACK));
            D8.setPiece(new Queen(this, D8, ChessPiece.Color.BLACK));
            E8.setPiece(new King(this,E8, ChessPiece.Color.BLACK));
            F8.setPiece(new Bishop(this, F8, ChessPiece.Color.BLACK));
            G8.setPiece(new Knight(this, G8, ChessPiece.Color.BLACK));
            H8.setPiece(new Rook(this, H8, ChessPiece.Color.BLACK));
            A7.setPiece(new Pawn(this, A7, ChessPiece.Color.BLACK));
            B7.setPiece(new Pawn(this, B7, ChessPiece.Color.BLACK));
            C7.setPiece(new Pawn(this, C7, ChessPiece.Color.BLACK));
            D7.setPiece(new Pawn(this, D7, ChessPiece.Color.BLACK));
            E7.setPiece(new Pawn(this, E7, ChessPiece.Color.BLACK));
            F7.setPiece(new Pawn(this, F7, ChessPiece.Color.BLACK));
            G7.setPiece(new Pawn(this, G7, ChessPiece.Color.BLACK));
            H7.setPiece(new Pawn(this, H7, ChessPiece.Color.BLACK));

            A1.setPiece(new Rook(this, A1, ChessPiece.Color.WHITE));
            B1.setPiece(new Knight(this, B1, ChessPiece.Color.WHITE));
            C1.setPiece(new Bishop(this, C1, ChessPiece.Color.WHITE));
            D1.setPiece(new Queen(this, D1, ChessPiece.Color.WHITE));
            E1.setPiece(new King(this, E1, ChessPiece.Color.WHITE));
            F1.setPiece(new Bishop(this, F1, ChessPiece.Color.WHITE));
            G1.setPiece(new Knight(this, G1, ChessPiece.Color.WHITE));
            H1.setPiece(new Rook(this, H1, ChessPiece.Color.WHITE));
            A2.setPiece(new Pawn(this, A2, ChessPiece.Color.WHITE));
            B2.setPiece(new Pawn(this, B2, ChessPiece.Color.WHITE));
            C2.setPiece(new Pawn(this, C2, ChessPiece.Color.WHITE));
            D2.setPiece(new Pawn(this, D2, ChessPiece.Color.WHITE));
            E2.setPiece(new Pawn(this, E2, ChessPiece.Color.WHITE));
            F2.setPiece(new Pawn(this, F2, ChessPiece.Color.WHITE));
            G2.setPiece(new Pawn(this, G2, ChessPiece.Color.WHITE));
            H2.setPiece(new Pawn(this, H2, ChessPiece.Color.WHITE));
        }
        

    }
    

    public ChessBoardSquare getSquare(ChessBoardSquare.ID id) {

        ChessBoardSquare[] arr = new ChessBoardSquare[1];
        traverseBoardForward(s -> {
            if (s.getId().equals(id)) {
                arr[0] = s;
            }
        });
        return arr[0];
    }

    public void traverseBoardForward(Visitor squareVisitor) {
        ChessBoardSquare currentSquare = A8;
        ChessBoardSquare currentRowHead = A8;

        while (currentRowHead != null) {

            while (currentSquare != null) {
                squareVisitor.visit(currentSquare);
                currentSquare = currentSquare.getEast();
            }
            currentRowHead = currentRowHead.getSouth();
            currentSquare = currentRowHead;
        }
    }

    public void traverseBoardBackward(Visitor squareVisitor) {
        ChessBoardSquare currentSquare = H1;
        ChessBoardSquare currentRowHead = H1;

        while (currentRowHead != null) {

            while (currentSquare != null) {
                squareVisitor.visit(currentSquare);
                currentSquare = currentSquare.getWest();
            }
            currentRowHead = currentRowHead.getNorth();
            currentSquare = currentRowHead;
        }
    }
    
    public void traverseBoardForward(Visitor rowVisitor, Visitor squareVisitor) {
        ChessBoardSquare currentSquare = A8;
        ChessBoardSquare currentRowHead = A8;

        while (currentRowHead != null) {

            while (currentSquare != null) {
                squareVisitor.visit(currentSquare);
                currentSquare = currentSquare.getEast();
            }
            rowVisitor.visit(currentRowHead);
            currentRowHead = currentRowHead.getSouth();
            currentSquare = currentRowHead;
        }
    }

    public void traverseBoardBackward(Visitor rowVisitor, Visitor squareVisitor) {
        ChessBoardSquare currentSquare = A1;
        ChessBoardSquare currentRowHead = A1;

        while (currentRowHead != null) {

            while (currentSquare != null) {
                squareVisitor.visit(currentSquare);
                currentSquare = currentSquare.getEast();
            }
            rowVisitor.visit(currentRowHead);
            currentRowHead = currentRowHead.getNorth();
            currentSquare = currentRowHead;
        }
    }

    public Game getGame() {
        return game;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        this.traverseBoardForward(r -> {str.append("\n");}, s -> {
            str.append(s.toString()).append(", ");});
        return str.toString();
    }

    public void printBoard() {
        StringBuilder str = new StringBuilder();

        this.traverseBoardForward(r -> {str.append("\n");}, s -> {
            if (s.hasPiece()) {
                str.append(s.getPiece().printable).append("  ");
            }
            else str.append("x").append("  ");

            if (!s.hasEast()) str.append("").append(s.getId().toString().substring(1));
        });

        str.append("A  B  C  D  E  F  G  H");

        System.out.println(str);


    }

    public void printBoardR() {
        StringBuilder str = new StringBuilder();

        this.traverseBoardBackward(r -> {str.append("\n");}, s -> {
            if (s.hasPiece()) {
                str.append(s.getPiece().printable).append("  ");
            }
            else str.append("x").append("  ");

            if (!s.hasEast()) str.append("").append(s.getId().toString().substring(1));
        });

        str.append("A  B  C  D  E  F  G  H");

        System.out.println(str);


    }
}

