import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();

        if (game.intro()) game.play();
    }

    private final ChessBoard board;
    private final Player p1;
    private final Player p2;
    private final Scanner scan = new Scanner(System.in);
    InvalidMoveException wrongPlayer = new InvalidMoveException("That piece does not belong to you");

    public Game() {
        p1 = new Player(ChessPiece.Color.WHITE, this);
        p2 = new Player(ChessPiece.Color.BLACK, this);
        board = new ChessBoard(true, this);

        p1.setupPlayer();
        p2.setupPlayer();
    }

    public ChessBoard getBoard() {return board;}
    public Player getP1() {
        return p1;
    }
    public Player getP2() {
        return p2;
    }

    private ChessBoardSquare.ID convertPlayerInputSquareID(String playerIn) {
        for (ChessBoardSquare.ID id : ChessBoardSquare.ID.values()) {
            if (playerIn.equalsIgnoreCase(id.toString())) return id;
        }
        throw new IllegalArgumentException("The player input for ChessBoardSquare ID did not match any valid ChessBoardSquare.");
    }

    private ChessBoardSquare.ID[] getMoveSquares(String[] arr) {
        ChessBoardSquare.ID[] returnArr = new ChessBoardSquare.ID[2];

            returnArr[0] = convertPlayerInputSquareID(arr[0]);
            returnArr[1] = convertPlayerInputSquareID(arr[2]);

        return returnArr;

    }

    public void playerTakeTurn(Player player) throws GameEndException{

        if (player.isKingInStalemate()) throw new GameEndException("STALEMATE");

        ChessBoardSquare fromSquare;
        ChessBoardSquare toSquare;

        System.out.print("\nYour turn " + player.getName() + ", Please enter your next move.\nExample valid input: \"A5 to C4\" or \"Castle\" to castle.\n> ");
        
        while (true) {
            ChessBoardSquare.ID[] moveArr;
            try {
                moveArr = getMoveSquares(scan.nextLine().split(" "));
            }
            catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + "\nPlease enter a valid move.\n>");
                continue;
            }

            fromSquare = board.getSquare(moveArr[0]);
            toSquare = board.getSquare(moveArr[1]);

            if (!fromSquare.hasPiece()) {
                System.out.print("Square " + fromSquare.getId() + " does not have a piece to move. Please enter a valid move.\n> ");
                continue;
            }



            try {
                if (!fromSquare.getPiece().getColor().equals(player.getColor())) throw wrongPlayer;
                fromSquare.getPiece().move(toSquare);
                break;
            }
            catch(InvalidMoveException e) {
                System.out.print(e.getMessage() + "\nEnter a valid move\n>");
            }

        }

    }



    public boolean intro() {
        clearScreen();
        String playerIn = "";

        while (true) {

            System.out.print("Welcome to Chess!\n\nAre you ready to play? (y/n)\n> ");

            playerIn = scan.nextLine();

            if (playerIn.equals("y")) return true;
            else if (playerIn.equals("n")) return false;

            else System.out.println("You must respond with either \"y\" or \"n\"\n\n\n");
        }
    }

    public void play() {
        clearScreen();
        System.out.print("Enter Player 1 Name\n> ");
        p1.setName(scan.nextLine());
        clearScreen();
        System.out.print("Enter Player 2 Name\n> ");
        p2.setName(scan.nextLine());
        clearScreen();

        gameLoop();


    }



    public void gameLoop() {
        while (true){
            try {
                board.printBoard();

                playerTakeTurn(p1);

                clearScreen();
                board.printBoardR();

                playerTakeTurn(p2);

                clearScreen();

            }
            catch (GameEndException e) {
                if (e.getMessage().equals("WIN" + p1.getName())) {
                    System.out.println(e.getMessage());
                    return;
                }
                if (e.getMessage().equals("WIN" + p2.getName())) {
                    System.out.println(e.getMessage());
                    return;
                }
                if (e.getMessage().equals("STALEMATE")) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
    }











    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
