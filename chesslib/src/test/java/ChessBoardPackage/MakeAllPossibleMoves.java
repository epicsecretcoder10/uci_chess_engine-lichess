package ChessBoardPackage;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

import java.util.List;

public class MakeAllPossibleMoves {

    public static void main(String[] args) {
        // Generate legal chess moves for the current position
        Board board = new Board();
        List<Move> moves = board.legalMoves();
        System.out.println("Legal moves: " + moves);

        for (Move move : moves) {
            board.doMove(move);
            //do something
            board.undoMove();
        }
        System.out.println("Legal moves: " + moves);
    }
}
