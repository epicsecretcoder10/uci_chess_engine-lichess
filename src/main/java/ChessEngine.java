import com.github.bhlangonijr.chesslib.*;

public class ChessEngine {

    public static void main(String[] args) {
        testGame();
    }

    public static void testGame() {
        Board board = new Board();
        Move move = new Move(Square.E2, Square.E4); // Create a Move object
        board.doMove(move);
        System.out.println(board.toString());
    }
}