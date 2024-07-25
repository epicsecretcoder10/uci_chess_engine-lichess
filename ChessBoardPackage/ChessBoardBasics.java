package ChessBoardPackage;

import chesslib.Board;
import chesslib.Move;
import chesslib.Piece;
import chesslib.Square;

public class ChessBoardBasics {

    public static void main(String[] args) {
        // Initialize the chess board
        Board board = new Board()

        // Print the initial board
        System.out.println("Initial Board:");
        System.out.println(board.toString());

        // Move a piece (example: move white pawn from e2 to e4)
        System.out.println("\nAfter moving a piece:");
        board.doMove(new Move(Square.E2, Square.E4));
        System.out.println(board.toString());
    }

    
}





